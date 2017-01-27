package w5.chat.client;

import w5.chat.Connection;
import w5.chat.User;
import w5.chat.manager.ConsoleManager;
import w5.chat.message.Message;
import w5.chat.message.MessageType;

import java.io.IOException;
import java.net.Socket;
import java.util.List;

/**
 * Created by Bohdan on 22.01.2017.
 */
public class Client
{
    private Connection connection;
    volatile boolean clientConnected;

    public class SocketThread extends Thread
    {
        protected void processIncomingTextMessage(String text)
        {
            ConsoleManager.showMessage(text);
        }

        protected void informAboutAddingNewUser(User user)
        {
            ConsoleManager.showMessage("User " + user.getLogin() + " added to the chat");
        }

        protected void informAboutDeletingUser(User user)
        {
            ConsoleManager.showMessage("User " + user.getLogin() + " removed from chat");
        }

        protected void processIncomingUserList(List<User> users)
        {
            ConsoleManager.showMessage("Users in chat\n" + String.valueOf(users));
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected)
        {
            Client.this.clientConnected = clientConnected;

            synchronized (Client.this)
            {
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException
        {
            while (true)
            {
                Message messageReceived = connection.receiveMessage();

                switch (messageReceived.getMessageType())
                {
                    case USER_REQUEST:
                    {
                        connection.sendMessage(new Message(MessageType.USER_OBJECT, getUser()));
                        break;
                    }
                    case USER_ACCEPTED:
                    {
                        notifyConnectionStatusChanged(true);
                        return;
                    }
                    default:
                    {
                        throw new IOException("Unexpected MessageType");
                    }
                }
            }
        }


        protected void clientMainLoop() throws IOException, ClassNotFoundException
        {
            while (true)
            {
                Message messageReceived = connection.receiveMessage();

                switch (messageReceived.getMessageType())
                {
                    case TEXT:
                    {
                        processIncomingTextMessage((String) messageReceived.getData());
                        break;
                    }
                    case USER_ADDED:
                    {
                        informAboutAddingNewUser((User) messageReceived.getData());
                        break;
                    }
                    case USER_LIST:
                    {
                        processIncomingUserList((List<User>) messageReceived.getData());
                        break;
                    }
                    case USER_REMOVED:
                    {
                        informAboutDeletingUser((User) messageReceived.getData());
                        break;
                    }
                    default:
                    {
                        throw new IOException("Unexpected MessageType");
                    }
                }
            }
        }

        public void run()
        {
            try
            {
                Socket socket = new Socket(getServerAddress(), getServerPort());
                connection = new Connection(socket);

                try
                {
                    clientHandshake();
                    clientMainLoop();
                }
                catch (ClassNotFoundException e)
                {
                    notifyConnectionStatusChanged(false);
                }
            }
            catch (IOException e)
            {
                notifyConnectionStatusChanged(false);
            }
        }
    }

    public boolean isClientConnected()
    {
        return clientConnected;
    }

    protected String getServerAddress()
    {
        ConsoleManager.showMessage("Enter server address");
        return ConsoleManager.readString();
    }

    protected int getServerPort()
    {
        ConsoleManager.showMessage("Enter server port");
        return ConsoleManager.readInt();
    }

    protected User getUser()
    {
        ConsoleManager.showMessage("Enter user name");
        return new User(ConsoleManager.readString());
    }

    protected SocketThread getSocketThread()
    {
        return new SocketThread();
    }


    protected void sendMessage(Message message)
    {
        try
        {
            connection.sendMessage(message);
        }
        catch (IOException e)
        {
            clientConnected = false;
        }
    }

    public void run()
    {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();

        try
        {
            synchronized (this)
            {
                this.wait();
            }
        }
        catch (InterruptedException e)
        {
            return;
        }

        if (clientConnected)
        {
            ConsoleManager.showMessage("Client was connected to the server");
        }
        else
        {
            ConsoleManager.showMessage("Error while connecting to server");
        }

        while (clientConnected)
        {
            String strMessage = ConsoleManager.readString();

            if (strMessage.equals("exit"))
            {
                break;
            }

            sendMessage(new Message(MessageType.TEXT, strMessage));
        }
    }

    public static void main(String[] args)
    {
        Client client = new Client();
        client.run();
    }
}
