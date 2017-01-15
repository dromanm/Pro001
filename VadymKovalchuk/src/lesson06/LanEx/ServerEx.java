package lesson06.LanEx;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by eriol4ik on 15/01/2017.
 */
public class ServerEx {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.bind(new InetSocketAddress(30000));

        SocketChannel socket = channel.accept();
        System.out.println(socket.getRemoteAddress());

        ByteBuffer buffer = ByteBuffer.allocate(128);
        int bytes = 0;
        while (true) {
            try {
                bytes = socket.read(buffer);
            } catch (IOException ioe) {
                break;
            }
            if (bytes <= 0) {
                break;
            }
            buffer.flip();
            String message = new String(buffer.array(), 0, bytes);
            buffer.clear();
            System.out.println(message);
        }
    }
}
