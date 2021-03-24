package 设计模式.责任链;

/**
 * @author XieDuoLiang
 * @date 2021/1/25 下午10:27
 */
public class ChainOfResponsibility {

    private Check chain;

    public void addCheck(Check check) {
        if (chain == null) {
            chain = check;
        } else {
            getLast(chain).setNextCheck(check);
        }
    }

    public boolean makeCheck(PurchaseReq purchaseReq) {
        return chain.check(purchaseReq);
    }

    private Check getLast(Check check) {
        Check last = check;
        while (last.getNextCheck() != null) {
            last = last.getNextCheck();
        }
        return last;
    }
}
