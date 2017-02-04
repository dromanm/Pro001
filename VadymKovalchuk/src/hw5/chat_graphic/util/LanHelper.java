package hw5.chat_graphic.util;

import hw5.chat_graphic.domain.Message;
import hw5.chat_graphic.domain.Type;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

import com.google.gson.Gson;

/**
 * Created by eriol4ik on 27/01/2017.
 */
public class LanHelper {
    private static Charset charset = Charset.forName("UTF-8");
    private static ByteBuffer bufferIn;
    private static ByteBuffer bufferOut;

    static {
        bufferIn = ByteBuffer.allocate(2048);
        bufferOut = ByteBuffer.allocate(2048);
    }


    public static String readMessage(SocketChannel socket) {
        int bytes;
        try {
            bytes = socket.read(bufferIn);
        } catch (IOException ioe) {
            return null;
        }
        if (bytes <= 0) {
            return null;
        }
        bufferIn.flip();
        CharBuffer charBuffer = charset.decode(bufferIn);
        String message = new String(charBuffer.array());
        bufferIn.clear();
        return message;
    }

    public static void writeMessage(String gsonString, SocketChannel socket, Type type) {
        Message message = new Message(type, gsonString);
        String gsonMessage = (new Gson()).toJson(message);
        bufferOut.put(gsonMessage.getBytes(charset));
//        bufferOut.put(charset.encode(gsonMessage)); // <--- line above or this one
        bufferOut.flip();
        try {
            socket.write(bufferOut);
        } catch (IOException e) {
            e.printStackTrace();
        }

        bufferOut.clear();
    }
}
