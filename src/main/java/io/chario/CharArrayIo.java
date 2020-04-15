package main.java.io.chario;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;

/**
 * @author zjq
 * @date 2020/4/15 19:58
 */
public class CharArrayIo {
    public static void main(String[] args) throws IOException {
        char[] src = "中国加油".toCharArray();
        char[] temp = new char[2];
        CharArrayReader charArrayReader = new CharArrayReader(src);
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        int len = -1;
        while ((len = charArrayReader.read(temp)) > -1){
            charArrayWriter.write(temp,0,len);
        }
        System.out.println(new String(temp));


    }
}
