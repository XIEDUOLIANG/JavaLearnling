package 设计模式.责任链;

/**
 * @author XieDuoLiang
 * @date 2021/1/25 下午10:07
 */
public class LoginCheck extends Check{

    @Override
    public boolean check(PurchaseReq purchaseReq) {
        //假设登录id是这个
        if ("USER_ID".equals(purchaseReq.getUserId())) {
            System.out.println("登录校验通过");
            return super.check(purchaseReq);
        }

        System.out.println("登录校验失败");
        return false;
    }
}
