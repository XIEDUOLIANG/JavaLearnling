package 设计模式.观察者;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author XieDuoLiang
 * @date 2020/11/18 下午5:35
 */
public class Publisher {

    private List<Observer> observers = new ArrayList<>();

    private Map<String,Stuff> map = new HashMap<>();

    public void register(Observer observer) {
        observers.add(observer);
    }

    public void remove(Observer observer) {
        observers.remove(observer);
    }

    public void publishStuff(String name, BigDecimal price) {
        Stuff stuff = new Stuff(name,price);
        map.put(name,stuff);
        observers.forEach(o -> o.onPublish(stuff));
    }

    public void changePrice(String name, BigDecimal price) {
        Stuff stuff = map.get(name);
        stuff.setPrice(price);
        observers.forEach(o -> o.onChangePrice(stuff));
    }
}
