package httpclient;

import sun.net.www.http.HttpClient;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author XieDuoLiang
 * @date 2020/11/18 下午9:30
 */
public class Client {

    //将全局httpClient在多线程中使用，导致线程不安全
    //static HttpClient httpClient = HttpClient.newBuilder().build();

    public static void main(String[] args) throws InterruptedException {
        /*ExecutorService executor = Executors.newFixedThreadPool(1000);
        for (int i = 0; i < 1000; i++) {
            //System.out.println(i);
            //每个线程创建一个httpClient，导致每个线程占用内存很大
            HttpClient httpClient = HttpClient.newBuilder().build();
            executor.submit(new HttpTask(httpClient));
            //Thread.sleep(10);
        }
        Thread.sleep(2000L);
        executor.shutdownNow();
        System.out.println(HttpTask.result);*/
    }
}
