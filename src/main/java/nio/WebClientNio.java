package main.java.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author zjq
 * @date 2020/4/16 21:59
 */
public class WebClientNio {
    public static void main(String[] args) {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("127.0.0.1",8000));

            ByteBuffer jYou = ByteBuffer.allocate(128);
            ByteBuffer aoLiGei = ByteBuffer.allocate(56);
            jYou.put(new String("中国加油").getBytes());
            aoLiGei.put(new String("奥利给").getBytes());
            jYou.flip();
            aoLiGei.flip();
            ByteBuffer[] params = {jYou,aoLiGei};

            socketChannel.write(params);
            socketChannel.shutdownOutput();
            jYou.clear();
            int len = 0;
            while ((len = socketChannel.read(jYou)) > -1){
                jYou.flip();
                System.out.println(new String(jYou.array(),0,len));
                jYou.clear();
            }

            socketChannel.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
