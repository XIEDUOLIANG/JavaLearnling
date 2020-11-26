package 设计模式.观察者;

/**
 * @author XieDuoLiang
 * @date 2020/11/18 下午5:30
 */
public class Customer implements Observer{
    
    @Override
    public void onPublish(Stuff stuff) {
        System.out.println("顾客观察到新商品: "+stuff.getName()+" 上架...");
    }

    @Override
    public void onChangePrice(Stuff stuff) {
        System.out.println("顾客观察到商品: "+stuff.getName()+" 价格变化...");
    }
}
