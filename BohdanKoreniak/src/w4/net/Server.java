package w4.net;

import hw2.authentication.ConsoleManager;
import w4.net.message.Message;
import w4.net.message.MessageType;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Bohdan on 15.01.2017.
 */
public class Server
{
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    private static class ConnectionHandler extends Thread
    {
        private SocketChannel socketChannel;

        public ConnectionHandler(SocketChannel socketChannel)
        {
            this.socketChannel = socketChannel;
        }

        public String serverHandshake(Connection connection) throws IOException, ClassNotFoundException
        {
            while (true)
            {
                connection.sendMessage(new Message(MessageType.NAME_REQUEST));

                Message receivedMessage = connection.receiveMessage();

                switch (receivedMessage.getMessageType())
                {
                    case USER_NAME:
                    {
                        String userName = receivedMessage.getTextData();

                        if (!userName.isEmpty() && connectionMap.get(userName) == null)
                        {
                            connectionMap.put(receivedMessage.getTextData(), connection);
                            connection.sendMessage(new Message(MessageType.USER_ACCEPTED));

                            ConsoleManager.printText("Connection with " + userName + " established. Remote address is " + connection.getSocketAddress());

                            return receivedMessage.getTextData();
                        }
                    }
                }
            }
        }

        public void serverMainLoop(String userName, Connection connection) throws IOException, ClassNotFoundException
        {
            while (true)
            {
                Message receivedMessage = connection.receiveMessage();

                switch (receivedMessage.getMessageType())
                {
                    case TEXT:
                    {
                        sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + receivedMessage.getTextData()));
                        break;
                    }
                    default:
                    {
                        ConsoleManager.printText("Error");
                        break;
                    }
                }
            }
        }

        @Override
        public void run()
        {
            try (Connection connection = new Connection(socketChannel))
            {
                String userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                serverMainLoop(userName, connection);
            }
            catch (IOException | ClassNotFoundException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void sendBroadcastMessage(Message message)
    {
        for (Map.Entry<String, Connection> entry : connectionMap.entrySet())
        {
            try
            {
                entry.getValue().sendMessage(message);
            }
            catch (IOException e)
            {
                ConsoleManager.printText("Error while sending message");
            }
        }
    }

    public static void main(String[] args)
    {
        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open())
        {
            ConsoleManager.printText("Enter server port");
            serverSocketChannel.bind(new InetSocketAddress(ConsoleManager.readInt()));

            ConsoleManager.printText("Server is running");

            while (true)
            {
                new ConnectionHandler(serverSocketChannel.accept()).start();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
