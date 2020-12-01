package stream;

import java.util.Collections;
import java.util.stream.Stream;

/**
 * @author XieDuoLiang
 * @date 2020/11/25 下午4:58
 */
public class TestReduce {

    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1,2,3);
        System.out.println(stream.reduce(0,(a,b) -> {
            System.out.println(b);
            a = a + b;
            return a;
        }));
        /*System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(-17%10);*/
        Class<? super String> clazz = String.class.getSuperclass();
        System.out.println(clazz);
    }
}
