package main.java.io.stream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zjq
 * @date 2020/4/14 11:29
 */
public class ObjectStreamIo {
    public static void main(String[] args) {
        writeObjectToFile();
        readObjectToStream();
    }
    public static  void readObjectToStream(){
        ObjectInputStream objectInputStream = null;

        try {
            objectInputStream = new ObjectInputStream(
                    new FileInputStream(new File("").getAbsolutePath()+"/"+"src/main/java/io/TestObjectStream.txt"));
            List<TestObjectStream> objects = (List<TestObjectStream>)objectInputStream.readObject();
            objects.forEach(o-> System.out.println(o));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void writeObjectToFile(){

        ObjectOutputStream objectOutputStream = null;

        try {
            File file = new File(new File("").getAbsolutePath()+"/"+"src/main/java/io/TestObjectStream.txt");
            file.delete();
            file.createNewFile();
            List<TestObjectStream> objects = new ArrayList<>();
            objects.add(new TestObjectStream("wac1",1));
            objects.add(new TestObjectStream("wac2",2));
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(objects);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
