package w4;

import hw2.authentication.ConsoleManager;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by Bohdan on 15.01.2017.
 */
public class LanExample
{
    public static void main(String[] args) throws IOException
    {
        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open())
        {
            ByteBuffer byteBuffer = ByteBuffer.allocate(128);

            serverSocketChannel.bind(new InetSocketAddress(3242));
            SocketChannel socketChannel = serverSocketChannel.accept();

            while (socketChannel.read(byteBuffer) > 0)
            {
                byteBuffer.flip();
                System.out.println(new String(byteBuffer.array()));
                byteBuffer.clear();
            }
        }

        /*try (SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("192.168.1.124", 8085)))
        {
            ByteBuffer byteBuffer = ByteBuffer.allocate(128);

            while (true)
            {
                String message = ConsoleManager.readString();
                byteBuffer.put(message.getBytes());

                byteBuffer.flip();
                socketChannel.write(byteBuffer);

                byteBuffer.clear();
            }
        }*/
    }
}
