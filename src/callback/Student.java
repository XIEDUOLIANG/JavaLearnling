package callback;

/**
 * @author XieDuoLiang
 * @date 2020/11/16 下午4:50
 */
public class Student{

    public void answer(CallBack callBack, String s) throws InterruptedException {
        System.out.println("student is busy");
        Thread.sleep(5000L);
        callBack.callBack(s);
    }
}
