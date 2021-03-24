package 多线程.线程池;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author XieDuoLiang
 * @date 2021/2/4 下午1:03
 */
public class ThreadPool {

    private List<Thread> threadList;

    private Queue<Runnable> taskQueue;

    private static class MyThread extends Thread {

        private Runnable task;

        public MyThread(Runnable task) {
            this.task = task;
        }

        @Override
        public void run() {
            while (task != null) {
                task.run();
            }
        }
    }

    public ThreadPool(int size) {
        threadList = new ArrayList<>(size);
    }

    public void addTask(Runnable task) {
        if (taskQueue == null) {
            taskQueue = new LinkedList<>();
        }
        taskQueue.add(task);
    }


}
