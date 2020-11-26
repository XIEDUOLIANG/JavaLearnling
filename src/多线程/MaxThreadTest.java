package 多线程;

/**
 * @author XieDuoLiang
 * @date 2020/11/19 上午9:58
 */
public class MaxThreadTest {

    public static void main(String[] args) {
        //无限开线程导致macos bigsur 11.01 重启系统
        for (int i = 0; i < 5000; i++) {
            System.out.println(i);
            new Thread(() -> {
                try {
                    Thread.sleep(100000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
