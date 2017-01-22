package w4.net;

import hw2.authentication.ConsoleManager;
import w4.net.message.Message;
import w4.net.message.MessageType;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

/**
 * Created by Bohdan on 15.01.2017.
 */
public class Client
{
    private Connection connection;

    private volatile boolean clientConnected;

    public String getServerAddress()
    {
        ConsoleManager.printText("Enter server address");
        return ConsoleManager.readString();
    }

    public int getServerPort()
    {
        ConsoleManager.printText("Enter server port");
        return ConsoleManager.readInt();
    }

    public String getUserName()
    {
        ConsoleManager.printText("Enter user name");
        return ConsoleManager.readString();
    }

    public void sendTextMessage(String text)
    {
        try
        {
            connection.sendMessage(new Message(MessageType.TEXT, text));
        }
        catch (IOException e)
        {
            clientConnected = false;
        }
    }

    public class SocketThread extends Thread
    {
        public void processIncomingUserAddedMessage(String userName)
        {
            ConsoleManager.printText(userName + " is connected to the chat");
        }

        public void processIncomingUserRemovedMessage(String userName)
        {
            ConsoleManager.printText(userName + "was disconnected from the chat");
        }

        public void processIncomingTextMessage(String message)
        {
            ConsoleManager.printText(message);
        }

        public void notifyConnectionStatusChanged(boolean clientConnected)
        {
            Client.this.clientConnected = clientConnected;

            synchronized (Client.this)
            {
                Client.this.notify();
            }
        }

        public void clientHandshake() throws IOException, ClassNotFoundException
        {
            while (true)
            {
                Message messageReceived = connection.receiveMessage();

                switch (messageReceived.getMessageType())
                {
                    case NAME_REQUEST:
                    {
                        connection.sendMessage(new Message(MessageType.USER_NAME, getUserName()));
                        break;
                    }
                    case USER_ACCEPTED:
                    {
                        notifyConnectionStatusChanged(true);
                        return;
                    }
                }
            }
        }

        public void clientMainLoop() throws IOException, ClassNotFoundException
        {
            while (true)
            {
                Message messageReceived = connection.receiveMessage();

                switch (messageReceived.getMessageType())
                {
                    case TEXT:
                    {
                        processIncomingTextMessage(messageReceived.getTextData());
                        break;
                    }
                    case USER_ADDED:
                    {
                        processIncomingUserAddedMessage(messageReceived.getTextData());
                        break;
                    }
                    case USER_REMOVED:
                    {
                        processIncomingUserRemovedMessage(messageReceived.getTextData());
                        break;
                    }
                }
            }
        }

        @Override
        public void run()
        {
            try
            {
                SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress(getServerAddress(), getServerPort()));
                connection = new Connection(socketChannel);

                clientHandshake();
                clientMainLoop();
            }
            catch (IOException | ClassNotFoundException e)
            {
                ConsoleManager.printText(e.getMessage());
                notifyConnectionStatusChanged(false);
            }
        }
    }

    public void run()
    {
        SocketThread socketThread = new SocketThread();
        socketThread.setDaemon(true);
        socketThread.start();

        synchronized (this)
        {
            try
            {
                this.wait();
            }
            catch (InterruptedException e)
            {
                ConsoleManager.printText(e.getMessage());
                return;
            }
        }

        if (clientConnected)
        {
            ConsoleManager.printText("Connection established successfully. Type your messages or 'exit' to exit from chat");
        }
        else
        {
            ConsoleManager.printText("Error while client work. Disconnecting");
        }

        while (clientConnected)
        {
            String strMessage = ConsoleManager.readString();

            if (strMessage.equals("exit"))
            {
                break;
            }

            sendTextMessage(strMessage);
        }
    }

    public static void main(String[] args)
    {
        new Client().run();
    }
}
