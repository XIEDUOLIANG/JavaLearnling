package jvm;

/**
 * @author XieDuoLiang
 * @date 2021/1/13 下午9:08
 */
public class StackOverFlowOOM {

    private static void dontStop() {
        while (true) {

        }
    }

    public static void main(String[] args) {
        /*while (true) {
            new Thread(StackOverFlowOOM::dontStop).start();
        }*/
    }
}
