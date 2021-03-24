package 设计模式.Filter;

/**
 * @author XieDuoLiang
 * @date 2021/1/24 下午2:54
 */
public interface Filter {

    Filter getNext();

    void setNext(Filter filter);

    Filter getLast();

    String execute(String str);
}
