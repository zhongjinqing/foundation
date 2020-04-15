package main.java.io.stream;


import java.io.*;

/**
 * @author zjq
 * @date 2020/4/14 20:17
 */
public class DataStreamIo {
    public static void main(String[] args) throws IOException {
        byte[] bytes = new String("\n中国加油").getBytes("UTF-8");
        System.out.println(bytes.length);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        byte[] result = new byte[6];
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
        dataInputStream.read(result,0,4);
        System.out.println(new String(result));


        String absolutePath = new File("").getAbsolutePath()+"/src/main/java/io/";
        File file = new File(absolutePath + "AllSeq.txt");

        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file,true));
        dataOutputStream.write(bytes);

    }
}
