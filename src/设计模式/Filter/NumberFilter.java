package 设计模式.Filter;

/**
 * @author XieDuoLiang
 * @date 2021/1/24 下午3:19
 */
public class NumberFilter extends AbstractFilter{

    @Override
    public String execute(String str) {
        String result = super.execute(str);
        for (int i = 0;i < str.length();i++) {
            if (Character.isDigit(str.charAt(i))) {
                return result+" 不能包含数字";
            }
        }
        return result;
    }
}
