package 多线程.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author XieDuoLiang
 * @date 2021/2/16 上午10:28
 */
public class CasTest {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        atomicInteger.incrementAndGet();
    }
}
