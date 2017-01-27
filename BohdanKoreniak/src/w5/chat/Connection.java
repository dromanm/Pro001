package w5.chat;

import w5.chat.message.Message;

import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by Bohdan on 22.01.2017.
 */
public class Connection implements Closeable
{
    private final Socket socket;
    private final ObjectInputStream objectInputStream;
    private final ObjectOutputStream objectOutputStream;

    public Connection(Socket socket) throws IOException
    {
        this.socket = socket;
        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectInputStream = new ObjectInputStream(socket.getInputStream());
    }

    public void sendMessage(Message message) throws IOException
    {
        synchronized (objectOutputStream)
        {
            objectOutputStream.reset();
            objectOutputStream.writeObject(message);
        }
    }

    public Message receiveMessage() throws IOException, ClassNotFoundException
    {
        synchronized (objectInputStream)
        {
            return (Message) objectInputStream.readObject();
        }
    }

    public String getRemoteSocketAddress()
    {
        return socket.getRemoteSocketAddress().toString();
    }

    @Override
    public void close() throws IOException
    {
        objectInputStream.close();
        objectOutputStream.close();
        socket.close();
    }
}
