package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author XieDuoLiang
 * @date 2020/11/24 下午5:07
 */
public class TestStream {

    /**
     * 测试stream效率
     * */
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        //填充字符串
        for (int i = 0; i < 5000000; i++) {
            int random = 65 + (int) (Math.random() * 12);
            int randomSize = (int) (Math.random() * 1000);
            char[] chars = new char[randomSize];
            for (int j = 0; j < randomSize; j++) {
                chars[j] = (char) random;
            }
            String s = String.valueOf(chars);
            list.add(s);
        }
        //list.forEach(System.out::println);

        //找出以 A开头的最长字符串长度
        //1. 普通方式（在一次迭代中完成，相当于流水线）
        long before1 = System.currentTimeMillis();
        int max = 0;
        for (String s:list) {
            if (s.startsWith("A")){          //相当于流水线中的filter -> .filter(s -> s.startsWith("A"))   (1)
                int length = s.length();     //相当于流水线中的map -> .mapToInt(String::length)            (2)
                max = Math.max(length,max);  //相当于流水线中的max -> .max()                               (3)
            }
        }
        long after1 = System.currentTimeMillis();
        System.out.println(max);
        System.out.println(after1 - before1);

        //2. stream方式(相当于记录用户的操作，在最后的结束操作中，在一次迭代中一次性完成）
        long before2 = System.currentTimeMillis();
        OptionalInt max2 = list.stream()
                .filter(s -> s.startsWith("A"))
                .mapToInt(String::length)
                .max();
        long after2 = System.currentTimeMillis();
        System.out.println(max2);
        System.out.println(after2 - before2);
    }
}
