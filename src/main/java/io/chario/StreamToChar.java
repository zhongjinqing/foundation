package main.java.io.chario;

import java.io.*;

/**
 * @author zjq
 * @date 2020/4/15 20:24
 */
public class StreamToChar {
    public static void main(String[] args) throws IOException {
        toReader();
        toWrite();
    }
    public static void toReader() throws IOException {
        String absolutePath = new File("").getAbsolutePath()+"/src/main/java/io/";
        File file = new File(absolutePath + "AllSeq.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file));
        FileReader fileReader = new FileReader(file);
        char[] chars = new char[100 * 2048];
        char[] chars2 = new char[100 * 2048];
        fileReader.read(chars);
        inputStreamReader.read(chars2);
        System.out.println(new String(chars));
        System.out.println(new String(chars2));

    }
    public static void toWrite() throws IOException {
        String absolutePath = new File("").getAbsolutePath()+"/src/main/java/io/";
        File file = new File(absolutePath + "AllSeq.txt");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file,true));
        FileWriter fileWriter = new FileWriter(file,true);
        fileWriter.write("AB");
        fileWriter.close();
        outputStreamWriter.write("CD");
        outputStreamWriter.close();

    }
}
