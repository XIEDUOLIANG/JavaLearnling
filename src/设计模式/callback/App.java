package 设计模式.callback;

/**
 * @author XieDuoLiang
 * @date 2021/1/25 下午2:48
 */
public class App {

    public static void main(String[] args) {
        Task task = new SimpleTask();
        task.executeWith(() -> System.out.println("我被回调了"));
    }
}
