package 适配器;

import java.util.concurrent.Callable;

public class Task implements Callable {


    private Integer num;

    public Task(Integer num){
        this.num = num;
    }

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Object call() throws Exception {
        System.out.println(num);
        return null;
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableAdapter(new Task(100)));
        thread.start();

    }
}

class RunnableAdapter implements Runnable{

    private Callable callable;

    public RunnableAdapter(Callable callable) {
        this.callable = callable;
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
    @Override
    public void run() {
        try {
            callable.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
