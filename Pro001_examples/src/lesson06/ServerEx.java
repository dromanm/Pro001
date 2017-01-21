package lesson06;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by IEvgen Boldyr on 15.01.17.
 */

public class ServerEx {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.bind(new InetSocketAddress(8089));

        SocketChannel socket = channel.accept();

        ByteBuffer buffer = ByteBuffer.allocate(128);
        int bytes = 0;
        while ((bytes = socket.read(buffer)) > 0) {
            buffer.flip();
            String message = new String(buffer.array(), 0, bytes);
            System.out.println(message);
        }
    }
}
