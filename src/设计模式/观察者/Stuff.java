package 设计模式.观察者;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author XieDuoLiang
 * @date 2020/11/18 下午5:27
 */
@Data
public class Stuff {

    private String name;

    private BigDecimal price;

    public Stuff(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }
}
