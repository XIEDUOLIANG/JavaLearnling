package 设计模式.Filter;

/**
 * @author XieDuoLiang
 * @date 2021/1/24 下午3:33
 */
public class App {

    public static void main(String[] args) {
        FilterChain chain = new FilterChain();
        chain.addFilter(new NumberFilter());
        chain.addFilter(new DirtyWordFilter());

        System.out.println(chain.execute("asdas fuck"));
    }
}
