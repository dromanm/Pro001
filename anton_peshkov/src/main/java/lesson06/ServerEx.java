package lesson06;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by admin on 15.01.17.
 */
public class ServerEx {
    public static void main(String[] args) {
        ServerSocketChannel channel = null;
        try {
            channel = ServerSocketChannel.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            channel.bind(new InetSocketAddress(8089));
        } catch (IOException e) {
            e.printStackTrace();
        }

        SocketChannel socket = null;
        try {
            socket = channel.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ByteBuffer buffer = ByteBuffer.allocate(128);
        int bytes = 0;
        do{
            try {
                bytes = socket.read(buffer);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("tut");
                break;
            }
            buffer.flip();
            if(bytes<=0)break;
            String message = new String(buffer.array(),0 ,bytes);
            System.out.println(message);
            buffer.clear();
        } while(socket.isConnected());
    }
}
