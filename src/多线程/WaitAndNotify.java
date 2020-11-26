package 多线程;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author XieDuoLiang
 * @date 2020/10/21 下午1:44
 */
public class WaitAndNotify {

    public static void main(String[] args) throws InterruptedException {
        var taskQueue = new TaskQueue();
        var getTasks = new ArrayList<Thread>();
        //启动获取任务线程
        for (int i = 0; i < 5; i++) {
            var t = new Thread(() -> {
                while (true) {
                    try {
                        String s = taskQueue.getTask();
                        System.out.println("任务："+s);
                    } catch (InterruptedException e) {
                        return;
                    }
                }
            });
            t.start();
            getTasks.add(t);
        }
        //启动添加任务线程
        var addTask = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                taskQueue.addTask("task-"+(int)(Math.random()*100));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        addTask.start();
        addTask.join();
        Thread.sleep(100);
        for (var getTask:getTasks) {
            getTask.interrupt();
        }
    }
}

class TaskQueue{

    Queue<String> queue = new LinkedList<>();

    public synchronized void addTask(String task){
        queue.add(task);
        this.notifyAll();
    }

    public synchronized String getTask() throws InterruptedException{
        while (queue.isEmpty()) {
            this.wait();
        }
        return queue.remove();
    }
}
