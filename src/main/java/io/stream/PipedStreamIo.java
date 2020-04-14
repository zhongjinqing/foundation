package main.java.io.stream;


import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Arrays;

/**
 * @author zjq
 * @date 2020/4/14 14:31
 */
public class PipedStreamIo {
    public static void main(String[] args) throws IOException {
        Sender sender = new Sender();
        Receiver receiver = new Receiver();
        receiver.getPipedInputStream().connect(sender.getPipedOutputStream());
        new Thread(sender).start();
        new Thread(receiver).start();
    }

}
class Sender implements Runnable{
    private PipedOutputStream  pipedOutputStream= new PipedOutputStream();
    @Override
    public void run() {
        try {
            System.out.println("中国加油");
            byte[][] data = {new String("中").getBytes(),new String("国").getBytes(),
                    new String("加").getBytes(),new String("油").getBytes()};
            int total = 0;
            int step = 2;
            for (int i = 0; i < data.length; i++) {
                pipedOutputStream.write(data[i]);
                Thread.sleep(2000);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }finally {
            try {
                pipedOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public PipedOutputStream getPipedOutputStream() {
        return pipedOutputStream;
    }

    public void setPipedOutputStream(PipedOutputStream pipedOutputStream) {
        this.pipedOutputStream = pipedOutputStream;
    }
}
class Receiver implements Runnable{
    private PipedInputStream  pipedInputStream = new PipedInputStream();
    @Override
    public void run() {
        byte[] temp = new byte[1024];
        byte[] result = new byte[30];
        int len = -1;
        int start = 0;
        int total = 0;
        try {
            while ((len = pipedInputStream.read(temp)) > -1){
                System.arraycopy(temp,0,result,start,len);
                System.out.println(new String(result));
                start += len;
                total += len;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                pipedInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public PipedInputStream getPipedInputStream() {
        return pipedInputStream;
    }

    public void setPipedInputStream(PipedInputStream pipedInputStream) {
        this.pipedInputStream = pipedInputStream;
    }
}
