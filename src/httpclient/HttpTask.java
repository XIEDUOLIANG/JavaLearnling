package httpclient;

import lombok.Data;
import lombok.SneakyThrows;

import java.net.http.HttpClient;

/**
 * @author XieDuoLiang
 * @date 2020/11/18 下午9:35
 */
@Data
public class HttpTask implements Runnable{

    private HttpClient httpClient;

    public static Integer result;

    public HttpTask(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @SneakyThrows
    @Override
    public void run() {
        int i = new SendHttp().sendHttp(httpClient);
        if (i % 10000 == 0) {
            result = i;
        }
    }

}
