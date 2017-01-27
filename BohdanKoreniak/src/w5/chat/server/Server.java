package w5.chat.server;

import w5.chat.Connection;
import w5.chat.User;
import w5.chat.manager.ConsoleManager;
import w5.chat.message.Message;
import w5.chat.message.MessageType;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * Created by Bohdan on 22.01.2017.
 */
public class Server
{
    private Map<User, Connection> connectionMap = new ConcurrentHashMap<>();

    boolean isServerRuns;

    class ConnectionHandler extends Thread
    {
        private Socket socket;

        public ConnectionHandler(Socket socket)
        {
            this.socket = socket;
        }

        public User serverHandshake(Connection connection) throws IOException, ClassNotFoundException
        {
            while (true)
            {
                connection.sendMessage(new Message(MessageType.USER_REQUEST));
                Message messageRespond = connection.receiveMessage();

                switch (messageRespond.getMessageType())
                {
                    case USER_OBJECT:
                    {
                        User user = (User) messageRespond.getData();

                        connectionMap.put(user, connection);
                        connection.sendMessage(new Message(MessageType.USER_ACCEPTED));

                        ConsoleManager.showMessage(
                                String.format("Connection with %s established. Remote socket address is %s",
                                user.getLogin(),
                                connection.getRemoteSocketAddress()));

                        return (User) messageRespond.getData();
                    }
                }
            }
        }

        public void serverMainLoop(User user, Connection connection) throws IOException, ClassNotFoundException
        {
            while (true)
            {
                Message messageReceived = connection.receiveMessage();

                switch (messageReceived.getMessageType())
                {
                    case TEXT:
                    {
                        processIncomingMessage(user.getLogin() + ": " + messageReceived.getData());
                        sendBroadcastMessage(new Message(MessageType.TEXT, user.getLogin() + ": " + messageReceived.getData()));
                        break;
                    }
                }
            }
        }

        @Override
        public void run()
        {
            User user = null;
            try (Connection connection = new Connection(socket))
            {
                user = serverHandshake(connection);

                sendBroadcastMessage(new Message(MessageType.USER_ADDED, user));
                sendBroadcastMessage(new Message(MessageType.USER_LIST, connectionMap.keySet().stream().collect(Collectors.toList())));

                serverMainLoop(user, connection);
            }
            catch (IOException | ClassNotFoundException e)
            {
            }

            if (user != null)
            {
                connectionMap.remove(user);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, user));
                sendBroadcastMessage(new Message(MessageType.USER_LIST, connectionMap.keySet().stream().collect(Collectors.toList())));
            }
        }
    }

    void processIncomingMessage(String text)
    {
        ConsoleManager.showMessage(text);
    }

    public void sendBroadcastMessage(Message message)
    {
        connectionMap.forEach((user, connection) ->
        {
            try
            {
                connection.sendMessage(message);
            }
            catch (IOException e)
            {
            }
        });
    }

    public boolean isServerRuns()
    {
        return isServerRuns;
    }

    public int getServerPort()
    {
        ConsoleManager.showMessage("Enter server port");
        return ConsoleManager.readInt();
    }

    public void run()
    {
        try (ServerSocket serverSocket = new ServerSocket(getServerPort()))
        {
            isServerRuns = true;
            ConsoleManager.showMessage("Server is running");
            while (true)
            {
                new ConnectionHandler(serverSocket.accept()).start();
            }
        }
        catch (IOException e)
        {
        }
    }

    public static void main(String[] args)
    {
        new Server().run();
    }
}
