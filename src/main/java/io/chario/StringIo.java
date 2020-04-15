package main.java.io.chario;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * @author zjq
 * @date 2020/4/15 20:07
 */
public class StringIo {
    public static void main(String[] args) throws IOException {
        String src = "ABCDE";
        char[] des = new char[4];
        StringReader stringReader = new StringReader(src);
        stringReader.read(des,0,4);
        System.out.println(new String(des));

        StringWriter stringWriter = new StringWriter();
        stringWriter.append("中国");
        stringWriter.append("加油");
        System.out.println(stringWriter.toString());
    }
}
