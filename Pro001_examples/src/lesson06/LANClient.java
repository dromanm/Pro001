package lesson06;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * Created by IEvgen Boldyr on 04.12.16.
 */
public class LANClient {

    private static SocketChannel channel;

    public static void main(String[] args) throws IOException {
        channel = SocketChannel.open(new InetSocketAddress("192.168.1.124", 8089));
        ByteBuffer buffer = ByteBuffer.allocate(128);

        String message;
        Scanner scan = new Scanner(System.in);
        while (true) {
            message = scan.nextLine();
            if (message.equals("exit")) break;
            send(message, buffer);
        }
    }

    private static void send(String message, ByteBuffer buffer) throws IOException {
        buffer.put(message.getBytes());
        while (buffer.hasRemaining()) {
            buffer.flip();
            channel.write(buffer);
        }
        buffer.clear();
    }
}
