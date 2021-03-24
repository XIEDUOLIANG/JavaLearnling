package 设计模式.Filter;

/**
 * @author XieDuoLiang
 * @date 2021/1/24 下午2:58
 */
public abstract class AbstractFilter implements Filter{

    private Filter next;

    @Override
    public Filter getNext(){
        return next;
    }

    @Override
    public void setNext(Filter filter){
        this.next = filter;
    }

    @Override
    public Filter getLast(){
        Filter filter = this;
        while (filter.getNext() != null) {
            filter = filter.getNext();
        }
        return filter;
    }

    @Override
    public String execute(String str){
        if (next != null) {
            return next.execute(str);
        } else {
            return "";
        }
    }
}
