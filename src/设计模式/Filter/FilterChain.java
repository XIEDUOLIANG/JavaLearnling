package 设计模式.Filter;

/**
 * @author XieDuoLiang
 * @date 2021/1/24 下午3:14
 */
public class FilterChain {

    private Filter chain;

    public void addFilter(Filter filter){
        if (chain == null) {
            chain = filter;
        } else {
            chain.getLast().setNext(filter);
        }
    }

    public String execute(String str) {
        return chain.execute(str);
    }
}
