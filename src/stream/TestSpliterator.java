package stream;

import java.util.List;
import java.util.Spliterator;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author XieDuoLiang
 * @date 2020/11/25 下午3:31
 */
public class TestSpliterator {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = TestSpliterator.generateList(100000000);
        Spliterator<Integer> spliteratorFirst = list.spliterator();
        Spliterator<Integer> spliteratorSecond = spliteratorFirst.trySplit();
        Spliterator<Integer> spliteratorThird = spliteratorSecond.trySplit();
        Spliterator<Integer> spliteratorFourth = spliteratorFirst.trySplit();
        /*list.forEach(System.out::println);
        System.out.println("first:");
        while (spliteratorFirst.tryAdvance(System.out::println));
        System.out.println("second:");
        while (spliteratorSecond.tryAdvance(System.out::println));
        System.out.println("third:");
        while (spliteratorThird.tryAdvance(System.out::println));*/


        //单线程计算某个数的数量
        /*before = System.currentTimeMillis();
        while (spliteratorFirst.tryAdvance(TestSpliterator::find));
        while (spliteratorSecond.tryAdvance(TestSpliterator::find));
        while (spliteratorThird.tryAdvance(TestSpliterator::find));
        while (spliteratorFourth.tryAdvance(TestSpliterator::find));
        after = System.currentTimeMillis();
        System.out.println(count);
        System.out.println(after - before);*/

        //多线程计算某个数的数量（时间：加锁 > 原子操作int > 不加锁）不加锁比上面快一倍 原子int比上面慢一倍 加锁比上面慢四倍
        before = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(new Task(spliteratorFirst));
        executorService.submit(new Task(spliteratorSecond));
        executorService.submit(new Task(spliteratorThird));
        executorService.submit(new Task(spliteratorFourth));

        Thread.sleep(2000L);
        //System.out.println(count1.get());
        System.out.println(count);
        System.out.println(after - before);
        executorService.shutdown();
    }

    private static long before;
    private static long after = 0;

    private static int count = 0;

    private static AtomicInteger count1 = new AtomicInteger(0);

    private static void find(Integer num) {
        if (num.equals(66666)) {
            count++;
        }
    }

    public static List<Integer> generateList(int size) {
        return Stream
                .generate(() -> (int) (Math.random() * 1000000))
                .limit(size)
                .collect(Collectors.toList());
    }

    private static class Task implements Runnable{

        private final Lock lock = new ReentrantLock();

        private Spliterator<Integer> spliterator;

        public Task(Spliterator<Integer> spliterator) {
            this.spliterator = spliterator;
        }

        @Override
        public void run() {
            while (spliterator.tryAdvance(num -> {
                if (num.equals(66666)) {
                    //count1.incrementAndGet();
                    count++;
                }
            }));
            after = Math.max(System.currentTimeMillis(),after);   //计算最后一个结束线程的当前系统时间戳
        }
    }
}
