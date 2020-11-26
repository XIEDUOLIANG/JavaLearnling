package 类的加载;

import lombok.Data;

/**
 * @author XieDuoLiang
 * @date 2020/8/4 2:53 下午
 */

public class SubClass extends SuperClass{

    static {
        System.out.println("SubClass init...");
    }

    public static final String TEST = "test";

}
