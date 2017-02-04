package hw5.chat_graphic.server;

import hw5.chat_graphic.domain.*;
import hw5.chat_graphic.util.LanHelper;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class Server {
    private List<Handler> handlers;
    private List<TextMessage> textMessages;

    // better to generate randomly session ID
    private Integer sessionId = 1;

    private Gson gson = new Gson();

    private static String url = "jdbc:mysql://localhost:3306/chat";
    private static String dbLogin = "root";
    private static String dbPassword = "qwerty";

    public static void main(String[] args) {
        Server server = new Server();
        server.init();
    }

    public Server() {
        handlers = new ArrayList<>();
        textMessages = new ArrayList<>();
    }

    public void init() {
        try {
            ServerSocketChannel channel = ServerSocketChannel.open();
            channel.bind(new InetSocketAddress("localhost", 30000));

            while (channel.isOpen()) {
                handlers.add(new Handler(channel.accept()));
                handlers.get(handlers.size() - 1).start();
                System.out.println("Connection accepted");
            }
        } catch (IOException ioe) {
            System.out.println("Error");
        }
    }


    private class Handler extends Thread {
        private SocketChannel socket;

        public Handler(SocketChannel socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            while (true) {
                readMessage();
            }
        }

        private void readMessage() {
            String gsonMessage = LanHelper.readMessage(this.socket);
            Message message = gson.fromJson(gsonMessage, Message.class);
            String gsonString = message.getGsonString();
            switch (message.getType()) {
                case TEXT_MESSAGE:
                    readTextMessage(gsonString);
                    break;
                case AUTHORIZE:
                    Result result1 = authorize(gsonString);
                    System.out.println(gson.toJson(result1));
                    writeMessage(gson.toJson(result1), Type.RESULT);
                    break;
                case REGISTER:
                    Result result2 = register(gsonString);
                    writeMessage(gson.toJson(result2), Type.RESULT);
                    break;
            }
        }

        private void writeMessage(String gsonString, Type type) {
            LanHelper.writeMessage(gsonString, this.socket, type);
        }

        private Result authorize(String gsonString) {
            SignData signData = gson.fromJson(gsonString, SignData.class);
            try {
                Connection connection = DriverManager.getConnection(url, dbLogin, dbPassword);
                String query = "SELECT `password` from USERS WHERE `login`=?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, signData.getLogin());
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    if (resultSet.getString(1).equals(signData.getPassword())) {
                        return new Result(Status.SUCCESS, sessionId++);
                    } else {
                        return new Result(Status.INCORRECT_PASSWORD, null);
                    }
                } else {
                    return new Result(Status.NO_SUCH_USER, null);
                }
            } catch (SQLException sqle) {
                sqle.printStackTrace();
                return new Result(Status.SQL_EXCEPTION, null);
            }
        }

        private Result register(String gsonString) {
            SignData signData = gson.fromJson(gsonString, SignData.class);
            String login = signData.getLogin();
            String password = signData.getPassword();
            try {
                Connection connection = DriverManager.getConnection(url, dbLogin, dbPassword);

                // check the user with this login in `users`
                String query1 = "SELECT `password` from USERS WHERE `login`=?";
                PreparedStatement statement1 = connection.prepareStatement(query1);
                statement1.setString(1, login);
                ResultSet resultSet = statement1.executeQuery();
                if (resultSet.next()) {
                    return new Result(Status.USER_EXISTS, null);
                } else {
                    // if not insert this new user into table `users`
                    String query2 = "INSERT INTO `users` (`login`, `password`) VALUES (?, ?)";
                    PreparedStatement statement2 = connection.prepareStatement(query2);
                    statement2.setString(1, login);
                    statement2.setString(2, password);
                    statement2.execute();
                    return new Result(Status.SUCCESS, sessionId++);
                }
            } catch (SQLException sqle) {
                sqle.printStackTrace();
                return new Result(Status.SQL_EXCEPTION, null);
            }
        }

        private void readTextMessage(String gsonString) {
            TextMessage textMessage = gson.fromJson(gsonString, TextMessage.class);
            textMessages.add(textMessage);

            // send other users this text message
            for (Handler handler : handlers) {
                if (handler != this) {
                    handler.writeMessage(gsonString, Type.TEXT_MESSAGE);
                }
            }
        }
    }
}
