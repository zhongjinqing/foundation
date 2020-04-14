package main.java.io.stream;

import java.io.*;

/**
 * @author zjq
 * @date 2020/4/14 16:55
 */
public class BufferedStreamIo {
    public static void main(String[] args) {
        bufferCpTime();
        streamCpTime();

    }
    public static void bufferCpTime(){
        File file = new File(new File("G:\\SpringFramework"), "core.pdf");
        File cpfile = new File(new File("G:\\SpringFramework"), "core-cp.pdf");
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        byte[] temp = new byte[1024];
        int len = -1;
        try {
            if (!cpfile.exists()){
                cpfile.createNewFile();
            }
            long start = System.currentTimeMillis();
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file),10*1048);
            bufferedOutputStream= new BufferedOutputStream(new FileOutputStream(cpfile));
            while ((len = bufferedInputStream.read(temp)) > -1){
                bufferedOutputStream.write(temp,0,len);
            }
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void streamCpTime(){
        File file = new File(new File("G:\\SpringFramework"), "core.pdf");
        File cpfile = new File(new File("G:\\SpringFramework"), "core-cp2.pdf");
        byte[] temp = new byte[1024];
        int len = -1;
        try {
            if (!cpfile.exists()){
                cpfile.createNewFile();
            }
            long start = System.currentTimeMillis();
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(cpfile);
            while ((len = fileInputStream.read(temp)) > -1){
                fileOutputStream.write(temp,0,len);
            }
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
