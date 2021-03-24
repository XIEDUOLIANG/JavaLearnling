package 设计模式.callback;

/**
 * @author XieDuoLiang
 * @date 2021/1/25 下午2:48
 */
public class SimpleTask extends Task{

    @Override
    void execute() {
        System.out.println("执行一个任务，然后回调");
    }
}
