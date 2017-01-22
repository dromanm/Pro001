package w4.net;

import w4.net.message.Message;

import java.io.*;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;

/**
 * Created by Bohdan on 15.01.2017.
 */
public class Connection implements Closeable
{
    private final SocketChannel socketChannel;
    private final ObjectInputStream objectInputStream;
    private final ObjectOutputStream objectOutputStream;

    public Connection(SocketChannel socketChannel) throws IOException
    {
        this.socketChannel = socketChannel;
        objectOutputStream = new ObjectOutputStream(socketChannel.socket().getOutputStream());
        objectInputStream = new ObjectInputStream(socketChannel.socket().getInputStream());
    }

    public Message receiveMessage() throws IOException, ClassNotFoundException
    {
        synchronized (objectInputStream)
        {
            return (Message) objectInputStream.readObject();
        }
    }

    public void sendMessage(Message message) throws IOException
    {
        synchronized (objectOutputStream)
        {
            objectOutputStream.reset();
            objectOutputStream.writeObject(message);
        }
    }

    public SocketAddress getSocketAddress() throws IOException
    {
        return socketChannel.getRemoteAddress();
    }

    @Override
    public void close() throws IOException
    {
        objectInputStream.close();
        objectOutputStream.close();
        socketChannel.close();
    }
}
