package 多线程;

/**
 * @author XieDuoLiang
 * @date 2020/10/20 下午4:22
 */
public class Test {

    public static void main(String[] args) throws InterruptedException{
        Thread task = new MyThread();
        task.start();
        Thread.sleep(1);
        task.interrupt();
        task.join();
        System.out.println("end");
    }

}

class MyThread extends Thread{

    @Override
    public void run(){
        int n = 0;
        while (! isInterrupted()) {
            n++;
            System.out.println(n);
        }
    }
}
