package lesson06;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by IEvgen Boldyr on 15.01.17.
 *
 * Сетевое взаимодействие
 */

//Интернет - набор сетей, который объеденен универсальным протоколом
//           для взаимодействия и обмена данными
//Протокол - набор универсальных правил для обмена информацией между
//           компьютерами
//Протоколы имеют 8 уровней
/* 1. Физический
   2. Канальный уровень.
   3. Сетевой уровень.     +
   4. Транстпортный.       +
   5 - 7.
   8. Прикладной.

   Протокол обмена данными по сети TCP/IP
   IP  - Internet Protocol - решается задача адресации между комп.
   TCP - Transmission Control Protocol - гарантированная передача данных

   XXX.XXX.XXX.XXX (IPv4) - формат адреса
   Порт - идентефикатор программы.

* */
public class LanExample {

    public static void main(String[] args) throws IOException {
        //192.168.1.124 : 8085
        SocketChannel channel = SocketChannel.open(
                new InetSocketAddress("192.168.1.124", 8085));
        ByteBuffer buffer = ByteBuffer.allocate(128);

        String testMessage = "Test MESSAGE";
        buffer.put(testMessage.getBytes());
        buffer.flip();
        channel.write(buffer);
        buffer.clear();

    }
}
