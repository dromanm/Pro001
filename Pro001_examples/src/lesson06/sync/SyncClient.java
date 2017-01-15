package lesson06.sync;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * Created by IEvgen Boldyr on 15.01.17.
 */
public class SyncClient {

    private static SocketChannel channel;

    public static void main(String[] args) throws IOException {
        channel = SocketChannel.open(new InetSocketAddress("192.168.1.124", 30000));
        ByteBuffer buffer = ByteBuffer.allocate(128);
        String message;
        Scanner scan = new Scanner(System.in);

        do {
            int bytes;
            while ((bytes = channel.read(buffer)) > 0) {
                buffer.flip();
                message = new String(buffer.array(), 0, bytes);
                System.out.println("Входящее сообщение от (сервер) : " + message);
                buffer.clear();
                break;
            }


            System.out.print("Сообщение для отправки : ");
            message = scan.nextLine();
            buffer.put(message.getBytes());
            buffer.flip();
            channel.write(buffer);
            buffer.clear();

        } while (true);
    }
}
