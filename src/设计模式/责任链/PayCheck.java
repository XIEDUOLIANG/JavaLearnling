package 设计模式.责任链;

/**
 * @author XieDuoLiang
 * @date 2021/1/25 下午10:07
 */
public class PayCheck extends Check{

    @Override
    public boolean check(PurchaseReq purchaseReq) {
        //假设商品一个100元
        if (100 * purchaseReq.getAmount() <= purchaseReq.getBalance()) {
            System.out.println("用户余额校验通过");
            return super.check(purchaseReq);
        }

        System.out.println("用户余额不足");
        return false;
    }
}
