package main.java.io.stream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author zjq
 * @date 2020/4/13 16:26
 */
public class ByteArrayStreamIo {
    public static void main(String[] args) throws IOException {
        String content = "中国加油中国加油中国加油中国加油中国加油";
        byte[] bytes = content.getBytes("UTF-8");
        byte[] tempBytes = new byte[20];
        //将bytes内容全部放入ByteArrayInputStream
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int len = -1;
        // byteArrayInputStream.read(tempBytes)读取内容到tempBytes，内容读空时返回-1
        while ((len = byteArrayInputStream.read(tempBytes)) > -1){
            //将tempBytes数据内容写入byteArrayOutputStream
            byteArrayOutputStream.write(tempBytes,0,len);
        }
        //将byteArrayOutputStream中内容转化成字符串
        String result = byteArrayOutputStream.toString("UTF-8");
        System.out.println(result);

    }
}
