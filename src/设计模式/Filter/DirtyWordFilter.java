package 设计模式.Filter;

/**
 * @author XieDuoLiang
 * @date 2021/1/24 下午3:31
 */
public class DirtyWordFilter extends AbstractFilter{

    private final static String DIRTY_WORD = "fuck";

    @Override
    public String execute(String str) {
        String result = super.execute(str);
        if (str.contains(DIRTY_WORD)) {
            return result+" 不能有敏感词汇";
        }
        return result;
    }
}
