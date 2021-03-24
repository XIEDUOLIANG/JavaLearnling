package jvm;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author XieDuoLiang
 * @date 2021/1/7 下午4:50
 */
public class JVMStackSOF {

    private int stackLength = 1;

    public void stackPush() {
        stackLength++;
        stackPush();
    }

    public static void main(String[] args) {
        JVMStackSOF jvmStackSOF = new JVMStackSOF();
        jvmStackSOF.stackPush();
        System.out.println(jvmStackSOF.stackLength);
        /*try {
            jvmStackSOF.stackPush();
        } catch (StackOverflowError error) {
            System.out.println(error.toString()+", stack length = "+jvmStackSOF.stackLength);
        }
        ExecutorService es = Executors.newFixedThreadPool(1000);
        for (int i = 0; i < 1000; i++) {
            es.submit(jvmStackSOF::stackPush);
        }
        es.shutdown();*/
    }
}
