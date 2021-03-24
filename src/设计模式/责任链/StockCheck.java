package 设计模式.责任链;

/**
 * @author XieDuoLiang
 * @date 2021/1/25 下午10:06
 */
public class StockCheck extends Check{

    @Override
    public boolean check(PurchaseReq purchaseReq) {
        //假设库存10
        if (10 > purchaseReq.getAmount()) {
            System.out.println("库存校验通过");
            return super.check(purchaseReq);
        }

        System.out.println("库存校验失败");
        return false;
    }
}
