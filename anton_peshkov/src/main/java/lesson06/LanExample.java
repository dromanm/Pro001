package lesson06;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class LanExample {

    public static void main(String[] args) throws IOException {
        SocketChannel channel = SocketChannel.open(new InetSocketAddress("192.168.1.127", 30000));
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        Scanner scanner = new Scanner(System.in);
        String testMessage;
        while(true) {
            testMessage = scanner.nextLine();
            if(testMessage.equals("exit")){
                channel.close();
                break;
            }
            byteBuffer.put(testMessage.getBytes());
            byteBuffer.flip();
            channel.write(byteBuffer);
            byteBuffer.clear();

        }
    }


}
