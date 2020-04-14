package main.java.io.stream;

import java.io.*;
import java.util.Arrays;

/**
 * 目前想到可用于文件合并操作
 * @author zjq
 * @date 2020/4/14 16:09
 */
public class SequenceStreamIo {
    public static void main(String[] args) {
        ObjectInputStream objectInputStream= null;
        FileInputStream fileInputStream = null;
        FileInputStream seqOne = null;
        SequenceInputStream sequenceInputStream = null;
        String absolutePath = new File("").getAbsolutePath()+"/src/main/java/io/";
        File file = new File(absolutePath + "AllSeq.txt");
        FileOutputStream allSeq = null;
        try {
            if (!file.exists()){
                file.createNewFile();
            }
            allSeq = new FileOutputStream(file);
            fileInputStream = new FileInputStream(absolutePath+"seqTwo.txt");
            seqOne = new FileInputStream(absolutePath+"seqOne.txt");
            sequenceInputStream = new SequenceInputStream(fileInputStream,seqOne);
            int len = -1;
            byte[] result = new byte[100*2048];
            byte[] temp = new byte[3];
            int start = 0;
            while ((len = sequenceInputStream.read(temp)) > -1){
                allSeq.write(temp,0,len);
                System.arraycopy(temp,0,result,start,len);
                start += len;
            }
            System.out.println(new String(result));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
