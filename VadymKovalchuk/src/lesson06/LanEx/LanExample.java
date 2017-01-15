package lesson06.LanEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by eriol4ik on 15/01/2017.
 */

public class LanExample implements Runnable {
    SocketChannel channel;
    ByteBuffer buffer;
    ByteBuffer bufferReceiver;
    int bytes;

    public static void main(String[] args) throws IOException {
        LanExample lanExample = new LanExample();
        lanExample.startSendingMessages();

    }

    private void startSendingMessages() throws IOException {
        channel = SocketChannel.open(new InetSocketAddress("192.168.1.129", 8089));
//        SocketChannel channel = SocketChannel.open(new InetSocketAddress("192.168.1.127", 30000));
        buffer = ByteBuffer.allocate(128); // объем данных, который передётся за раз (в байтах)
        bufferReceiver = ByteBuffer.allocate(128); // объем данных, который передётся за раз (в байтах)

        Thread thread = new Thread(this);
        thread.start();

//        String testMessage = "Hello!";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String testMessage = "";

        while (true) {
            System.out.println("Type your message:");
            testMessage = br.readLine();
            if (testMessage.equals("exit")) {
                channel.close();
                break;
            }

            buffer.put(testMessage.getBytes());
            buffer.flip();
            channel.write(buffer);
            buffer.clear();
//          -------------------------------------

        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                bytes = channel.read(bufferReceiver);
            } catch (IOException ioe) {
                break;
            }
            if (bytes <= 0) {
                break;
            }
            bufferReceiver.flip();
            String message = new String(bufferReceiver.array(), 0, bytes);
            bufferReceiver.clear();
            System.out.println(message);
        }
    }
}
