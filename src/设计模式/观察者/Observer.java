package 设计模式.观察者;

/**
 * @author XieDuoLiang
 * @date 2020/11/18 下午5:25
 */
public interface Observer {

    void onPublish(Stuff stuff);

    void onChangePrice(Stuff stuff);
}
