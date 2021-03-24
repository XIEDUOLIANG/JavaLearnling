package 分析对象;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author XieDuoLiang
 * @date 2021/2/16 下午2:56
 */
public class AnalyzeObject {

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(6000);

        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        /*synchronized (o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }*/
    }
}
