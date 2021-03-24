package 多线程;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author XieDuoLiang
 * @date 2021/1/15 下午7:27
 */
public class TestThread {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<Integer> future = executorService.submit(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 2;
        });
        System.out.println(future.get());
        System.out.println("123");
        executorService.shutdown();*/

        CompletableFuture<Double> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (Math.random() < 0.5) {
                throw new RuntimeException("获取失败");
            }
            return Math.random() * 2 + 5;
        });
        future.thenAccept(System.out::println);
        future.exceptionally(e -> {
            e.printStackTrace();
            return null;
        });
        System.out.println("before");

        Thread.sleep(2000);
    }


}
