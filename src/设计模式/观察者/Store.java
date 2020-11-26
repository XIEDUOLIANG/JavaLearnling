package 设计模式.观察者;

/**
 * @author XieDuoLiang
 * @date 2020/11/18 下午5:29
 */
public class Store implements Observer{

    @Override
    public void onPublish(Stuff stuff) {
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("商店观察到新商品: "+stuff.getName()+" 上架...");
    }

    @Override
    public void onChangePrice(Stuff stuff) {
        System.out.println("商店观察到商品: "+stuff.getName()+" 价格变化...");
    }
}
