package main.java.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author zjq
 * @date 2020/4/16 21:54
 */
public class WebServerNio {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel ssc = null;
        SocketChannel socketChannel = null;
        try {
            ssc = ServerSocketChannel.open();
            ssc.socket().bind(new InetSocketAddress("127.0.0.1",8000));
            while (true) {
                socketChannel = ssc.accept();

                ByteBuffer byteBuffer = ByteBuffer.allocate(58);
                ByteBuffer byteBuffer2 = ByteBuffer.allocate(3);

                ByteBuffer[] results = {byteBuffer, byteBuffer2};
                //read如果只指定缓冲区数字，那么第一个缓冲区足够大,数据不会存放到第二个缓冲区

                //可指定从哪个缓冲区开始读，用几个缓冲区
                socketChannel.read(results, 1, 1);
                while (socketChannel.read(results) != -1) {
                    for (ByteBuffer result : results) {
                        result.flip();
                        int start = 0;
                        byte[] temp = new byte[128];
                        while (result.hasRemaining()) {
                            temp[start++] = result.get();
                        }
                        result.clear();
                        System.out.println(new String(temp) + "\n");
                    }
                }
                byteBuffer.put("服务端接收成功".getBytes());
                byteBuffer.flip();
                socketChannel.write(byteBuffer);
                socketChannel.shutdownOutput();



            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            socketChannel.close();
            ssc.close();
        }

    }
}
