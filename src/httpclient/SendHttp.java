package httpclient;

import com.sun.deploy.net.HttpRequest;
import sun.net.www.http.HttpClient;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

/**
 * @author XieDuoLiang
 * @date 2020/11/19 上午11:11
 */
public class SendHttp {

    public Integer sendHttp(HttpClient httpClient) throws Exception {
        /*String url = "http://localhost:8886/single/single/test";
        String body = "num=10";
        HttpRequest request = HttpRequest.newBuilder(new URI(url))
                // 设置Header:
                .header("Accept", "")
                .header("Content-Type", "application/x-www-form-urlencoded")
                // 设置超时:
                .timeout(Duration.ofSeconds(10))
                // 设置版本:
                .version(HttpClient.Version.HTTP_2)
                // 使用POST并设置Body:
                .POST(HttpRequest.BodyPublishers.ofString(body, StandardCharsets.UTF_8)).build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        int s = Integer.parseInt(response.body());
        if (s % 10000 == 0) {
            return s;
        }*/
        return 0;
    }
}
