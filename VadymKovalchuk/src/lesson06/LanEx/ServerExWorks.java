package lesson06.LanEx;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Scanner;


public class ServerExWorks implements Runnable {

    String message;
    ByteBuffer bufferSend;
    SocketChannel socket;

    public static void main(String[] args) throws IOException {
        ServerExWorks serverEx = new ServerExWorks();

        serverEx.methodStart();
    }

    private void methodStart() throws IOException {
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.bind(new InetSocketAddress(8089));

        socket = channel.accept();


        ByteBuffer buffer = ByteBuffer.allocate(128);
        bufferSend = ByteBuffer.allocate(128);

        Thread thread = new Thread(this);
        thread.start();

        int bytes = 0;
        do {
            try {
            bytes = socket.read(buffer);
        } catch(IOException ioe) {
            break;
        }
            buffer.flip();
            message = new String(buffer.array(), 0, bytes);
            System.out.println(message);

            buffer.clear();
        } while (socket.isConnected());
    }

    @Override
    public void run() {
        while(true) {
            Scanner scanner = new Scanner(System.in);
            message = scanner.nextLine();
            bufferSend.put(message.getBytes());
            bufferSend.flip();
            try {
                socket.write(bufferSend);
            } catch (IOException e) {
                e.printStackTrace();
            }

            bufferSend.clear();
        }

    }
}
