package 数学.逻辑运算;

/**
 * @author XieDuoLiang
 * @date 2020/11/25 上午10:59
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(0x4000 | 0x0040 | 0x0010);
        int x = 3;
        System.out.println(~x);
        System.out.println(Integer.toBinaryString(-4));
        System.out.println(Integer.toBinaryString(3));
    }
}
