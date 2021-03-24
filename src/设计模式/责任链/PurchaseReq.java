package 设计模式.责任链;

import lombok.Data;

/**
 * @author XieDuoLiang
 * @date 2021/1/25 下午10:10
 */
@Data
public class PurchaseReq {

    private String userId;

    private Integer amount;

    private Integer balance;
}
