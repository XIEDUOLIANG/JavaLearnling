package jvm;

/**
 * @author XieDuoLiang
 * @date 2021/1/14 下午12:23
 */
public class GCTest {

    static class ObjectGC {

        private Object instance;

        private byte[] someMemory = new byte[1024*1024*200];
    }

    public void testCountGC() {
        ObjectGC a = new ObjectGC();
        ObjectGC b = new ObjectGC();
        a.instance = b;
        b.instance = a;
        a = null;
        //b = null;
        System.gc();
    }

    public static void main(String[] args) {
        new GCTest().testCountGC();
    }
}
