package main.java.io.chario.seletor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @author zjq
 * @date 2020/4/19 23:42
 */
public class NonBlockServer {
    public static void main(String[] args) {
        ServerSocketChannel ssc = null;
        try {
            ssc = ServerSocketChannel.open();
            ssc.bind(new InetSocketAddress("127.0.0.1",7878));
            ssc.configureBlocking(false);
            Selector selector = Selector.open();
            ssc.register(selector, SelectionKey.OP_ACCEPT);

            ByteBuffer bf = ByteBuffer.allocate(1024);
            int i = 0;
            while ((i = selector.select()) > 0){
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey sk = iterator.next();
                    if (sk.isAcceptable()){
                        SocketChannel channel = ssc.accept();
                        channel.configureBlocking(false);
                        channel.register(selector,SelectionKey.OP_READ);
                    }else if (sk.isReadable()){
                        SocketChannel channel = (SocketChannel)sk.channel();
                        int len = 0;
                        int start = 0;
                        StringBuffer resStr = new StringBuffer();
                        while ((len = channel.read(bf)) > 0){
                            bf.flip();
                            resStr.append(new String(bf.array(),0,bf.limit()));
                            bf.clear();
                        }
                        System.out.println(resStr.toString());

                    }
                    iterator.remove();
                }


            }


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(ssc != null){
                try {
                    ssc.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
