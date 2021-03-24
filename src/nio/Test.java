package nio;

import sun.nio.ch.FileChannelImpl;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author XieDuoLiang
 * @date 2021/2/9 下午2:19
 */
public class Test {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/Users/xieduoliang/Desktop/未命名.txt");
        FileChannel fileChannel = FileChannel.open(path);
        ByteBuffer byteBuffer = ByteBuffer.allocate(5);
        fileChannel.read(byteBuffer);
        for (int i = 0; i <byteBuffer.capacity() ; i++) {
            System.out.println(byteBuffer.get(i));
        }
        System.out.println((char)116);
        System.out.println("系统默认编码：    "+System.getProperty("file.encoding"));
    }
}
