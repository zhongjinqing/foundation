package main.java.nio;

import java.nio.ByteBuffer;

/**
 * @author zjq
 * @date 2020/4/16 21:10
 */
public class ByteBufferNio {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(256);
        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.position());


        //将缓冲区单做写缓冲区
        byteBuffer.put((byte) 1);
        byteBuffer.put((byte) 2);
        //-P------------------------l
        //12------------------------l

        //反转写缓冲区成读缓冲区
        byteBuffer.flip();
        //记录当前p的位置，用于读写操作之后reset复位
        byteBuffer.mark();
        //pl
        //12

        System.out.println(byteBuffer.get());
        System.out.println(byteBuffer.get());
        //-lp
        //12
        System.out.println(byteBuffer.position());
        byteBuffer.reset();
        System.out.println(byteBuffer.position());
        //pl
        //12


    }
}
