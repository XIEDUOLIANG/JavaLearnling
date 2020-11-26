package io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * @author XieDuoLiang
 * @date 2020/11/13 下午5:28
 */
public class IOTest {

    public static void main(String[] args) throws IOException {
        /*char c = '\u0000';
        char[] chars = new char[3];
        chars[0] = '1';
        chars[1] = '2';
        chars[2] = c;
        String s = new String(chars);
        System.out.println(s.indexOf('\u0000'));*/
        /*try(InputStream inputStream = new FileInputStream("/Users/xieduoliang/Desktop/test翻译.txt")) {
            int read = inputStream.available();
            if (read > 0) {
                byte[] bytes = new byte[12];
                int read1 = inputStream.read(bytes,2,10);
                StringBuffer string = new StringBuffer();
                System.out.println(string.append(new String(bytes)));
                System.out.println(string.length());
            }
        }*/

        /*try(DataOutputStream outputStream = new DataOutputStream(new FileOutputStream("/Users/xieduoliang/Desktop/testIo.txt"))) {
            outputStream.writeInt(12345);
            outputStream.writeInt(12345);
            outputStream.writeInt(12345);
            outputStream.flush();
        }*/
        try(DataInputStream inputStream = new DataInputStream(new FileInputStream("resource/testIo.txt"))) {
            int ch1 = inputStream.read();
            int ch2 = inputStream.read();
            int ch3 = inputStream.read();
            int ch4 = inputStream.read();
            System.out.println(ch1);
            System.out.println(ch2);
            System.out.println(ch3);
            System.out.println(ch4);
            System.out.println(ch1 << 24);
            System.out.println((ch1 << 24) + (ch2 << 16) + (ch3 << 8) + (ch4));
            int a = 187;
            System.out.println(a << 24);
        }
        /*System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperties());*/

        /**
         * 上文的232 十进制 如何与下文的8c对应
         * 232 -> 1110(去掉符号位置 110->c) 1000(8)
         * 上文的162 十进制 如何与下文的22对应
         * 162 -> 1010(去掉符号位 10->2) 0010(2)
         * */

        try(InputStreamReader reader = new InputStreamReader(
                new FileInputStream(new File("resource/testIo.txt")))) {
            int read = reader.read(); //读入unicode元码
            System.out.println(reader.getEncoding());  //utf8编码是unicode编码的一种实现方式
            System.out.println(read);
            String s=Integer.toHexString(read);   //10进制转16进制
            System.out.println(unicodeToString("\\u"+s));
            System.out.println(stringToUnicode("谢铎亮"));
            System.out.println((char)35874);    //char 0~65535
        }

        try(PrintWriter writer = new PrintWriter(new File("resource/testIo.txt"))) {
            writer.write("谢铎亮");
        }
    }

    public static String unicodeToString(String unicode) {
        StringBuffer sb = new StringBuffer();
        String[] hex = unicode.split("\\\\u");
        System.out.println(Arrays.toString(hex));
        for (int i = 1; i < hex.length; i++) {
            int index = Integer.parseInt(hex[i], 16);
            sb.append((char) index);
        }
        return sb.toString();
    }

    public static String stringToUnicode(String str) {
        StringBuffer sb = new StringBuffer();
        char[] c = str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            sb.append("\\u" + Integer.toHexString(c[i]));
        }
        return sb.toString();
    }


}
