package 设计模式.责任链;

/**
 * @author XieDuoLiang
 * @date 2021/1/25 下午9:39
 */
public class App {

    public static void main(String[] args) {
        PurchaseReq purchaseReq = new PurchaseReq();
        purchaseReq.setUserId("USER_ID");
        purchaseReq.setAmount(100);
        purchaseReq.setBalance(200);

        ChainOfResponsibility chain = new ChainOfResponsibility();
        chain.addCheck(new LoginCheck());
        chain.addCheck(new PayCheck());
        chain.addCheck(new StockCheck());

        boolean check = chain.makeCheck(purchaseReq);
        System.out.println(check);
    }
}
