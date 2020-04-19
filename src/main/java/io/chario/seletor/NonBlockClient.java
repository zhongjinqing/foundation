package main.java.io.chario.seletor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Scanner;

/**
 * @author zjq
 * @date 2020/4/20 0:07
 */
public class NonBlockClient {
    public static void main(String[] args) throws IOException {
        SocketChannel sc = SocketChannel.open(new InetSocketAddress("127.0.0.1",7878));
        sc.configureBlocking(false);

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String next = scanner.next();
            buffer.put((new Date().toString()+":\n"+next).getBytes());
            buffer.flip();
            sc.write(buffer);
            buffer.clear();
        }
        sc.close();

    }
}
