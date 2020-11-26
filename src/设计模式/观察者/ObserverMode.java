package 设计模式.观察者;

import java.math.BigDecimal;

/**
 * 观察者模式
 *
 * @author XieDuoLiang
 * @date 2020/11/18 下午5:23
 */
public class ObserverMode {

    public static void main(String[] args) {
        Publisher publisher = new Publisher();
        Store store = new Store();
        Customer customer = new Customer();

        //注册观察者
        publisher.register(store);
        publisher.register(customer);

        //发布新货
        publisher.publishStuff("apple",new BigDecimal(6000));

        //价格修改
        publisher.changePrice("apple",new BigDecimal(8000));
    }
}
