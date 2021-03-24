package jvm;

/**
 * @author XieDuoLiang
 * @date 2021/1/14 下午3:48
 */
public class FinalizeGCTest {

    public static FinalizeGCTest instance;

    @Override
    protected void finalize() {
        System.out.println("复活");
        instance = this;
    }

    public void printInfo() {
        System.out.println("活着");
    }

    public static void main(String[] args) throws Exception{
        instance = new FinalizeGCTest();
        instance = null;
        System.gc();
        //处理finalize的线程优先级很低，等待finalize
        Thread.sleep(500);

        if (instance != null) {
            instance.printInfo();
        } else {
            System.out.println("对象被回收");
        }

        instance = null;
        System.gc();
        //处理finalize的线程优先级很低，等待finalize
        Thread.sleep(500);
        if (instance != null) {
            instance.printInfo();
        } else {
            System.out.println("对象被回收");
        }
    }
}
