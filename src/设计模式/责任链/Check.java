package 设计模式.责任链;

import lombok.Data;

/**
 * @author XieDuoLiang
 * @date 2021/1/25 下午10:08
 */
@Data
public abstract class Check {

    private Check nextCheck;

    public boolean check(PurchaseReq purchaseReq) {
        if (nextCheck != null) {
            return nextCheck.check(purchaseReq);
        }
        return true;
    }
}
