package w4.net;

import w4.net.message.Message;

import java.io.*;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by Bohdan on 15.01.2017.
 */
public class Connection implements Closeable
{
    private final SocketChannel socketChannel;
    private ByteBuffer byteBuffer;

    public Connection(SocketChannel socketChannel)
    {
        this.socketChannel = socketChannel;
        byteBuffer = ByteBuffer.allocate(128);
    }

    public Message receiveMessage() throws IOException, ClassNotFoundException
    {
        synchronized (socketChannel)
        {
            Message message;

            try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream())
            {
                while (socketChannel.read(byteBuffer) > 0)
                {
                    byteBuffer.flip();
                    socketChannel.read(byteBuffer);

                    byteArrayOutputStream.write(byteBuffer.array());

                    byteBuffer.clear();
                }

                message = bytesToMessage(byteArrayOutputStream.toByteArray());
            }

            return message;
        }
    }

    public void sendMesssage(Message message) throws IOException
    {
        synchronized (socketChannel)
        {
            byteBuffer.flip();
            byteBuffer.put(messageToBytes(message));

            socketChannel.write(byteBuffer);

            byteBuffer.clear();
        }
    }

    public SocketAddress getSocketAddress() throws IOException
    {
        return socketChannel.getRemoteAddress();
    }

    private byte[] messageToBytes(Message message) throws IOException
    {
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream())
        {
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream))
            {
                objectOutputStream.writeObject(message);
                objectOutputStream.flush();

                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    private Message bytesToMessage(byte[] bytes) throws IOException, ClassNotFoundException
    {
        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes))
        {
            try (ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream))
            {
                return (Message) objectInputStream.readObject();
            }
        }
    }

    @Override
    public void close() throws IOException
    {
        byteBuffer.clear();
        socketChannel.close();
    }
}
