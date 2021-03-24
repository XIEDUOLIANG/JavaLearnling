package 多线程;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.StampedLock;

/**
 * @author XieDuoLiang
 * @date 2020/10/21 下午3:23
 */
/*public class StampedLockTest {

    public static void main(String[] args) throws InterruptedException {
        var point = new Point();
        var getPoints = new ArrayList<Thread>();

        for (int i = 0; i < 5; i++) {
            var task = new Thread(){
                public void run(){
                    while (!isInterrupted()) {
                        double result = point.getPoint();
                        System.out.println("point: "+result);
                    }
                }
            };
            task.start();
            getPoints.add(task);
        }

        var addPoint = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                point.movePoint(1,1);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        addPoint.start();
        *//*while (!addPoint.isAlive()) {

        }*//*
        addPoint.join();
        Thread.sleep(1000);
        for (var getPoint:getPoints) {
            getPoint.interrupt();
        }
    }
}

class Point{

    private double x = 1;
    private double y = 1;
    private final StampedLock stampedLock = new StampedLock();

    public void movePoint(double x,double y){
        long stamp = stampedLock.writeLock();
        try {
            this.x += x;
            this.y += y;
            //stampedLock.notifyAll();
        } finally {
            stampedLock.unlock(stamp);
        }
    }

    public double getPoint() {
        //获取乐观读锁
        long stamp = stampedLock.tryOptimisticRead();

        //读 5 的倍数
        *//*while (!(this.x/5 == 0 && this.y/5 == 0)){
            stampedLock.wait();
        }*//*
        double currentX = this.x;
        double currentY = this.y;

        if (!stampedLock.validate(stamp)) {
            //读的过程中，发生了写入，获取悲观读锁，重新读
            stamp = stampedLock.readLock();
            try {
                *//*while (!(this.x/5 == 0 && this.y/5 == 0)){
                    stampedLock.wait();
                }*//*
                currentX = this.x;
                currentY = this.y;
            } finally {
                stampedLock.unlock(stamp);
            }
        }

        return Math.sqrt(currentX*currentX+currentY*currentY);
    }
}*/
