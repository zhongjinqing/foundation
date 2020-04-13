package main.java.io.stream;

import java.io.*;

/**
 * @author zjq
 * @date 2020/4/13 20:59
 */
public class FileStreamIo {
    public static void main(String[] args){
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(new File("").getAbsolutePath()+"/"+"src/main/java/io/IO流概述.txt");
            File cpFile = new File(new File("").getAbsolutePath()+"/"+"src/main/java/io/IO流概述-cp.txt");
            fileOutputStream = new FileOutputStream(cpFile);
            byte[] temp = new byte[20];
            int len = -1;
            while ((len = fileInputStream.read(temp)) > -1){
                fileOutputStream.write(temp,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
