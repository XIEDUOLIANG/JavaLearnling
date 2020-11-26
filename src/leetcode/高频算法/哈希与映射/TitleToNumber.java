package leetcode.高频算法.哈希与映射;

/**
 * @author XieDuoLiang
 * @date 2020/10/29 上午10:43
 */
public class TitleToNumber {

    public static void main(String[] args) {
        System.out.println(new TitleToNumber().titleToNumber("AJHX"));
        System.out.println('J'-'A');
    }

    /**
     * 给定一个Excel表格中的列名称，返回其相应的列序号
     *     A -> 1
     *     B -> 2
     *     C -> 3
     *     ...
     *     Z -> 26
     *     AA -> 27
     *     AB -> 28
     *     ...
     * 输入: "ZY"
     * 输出: 701
     * */
    public int titleToNumber(String s) {
        int answer = 0;
        for (int i = s.length() - 1,j = 0; i >= 0 && j < s.length(); i--,j++) {
            if (i != 0){
                answer = answer + (1 + s.charAt(j) - 'A') * (int) Math.pow(26,i);
            } else {
                answer = answer + (1 + s.charAt(j) - 'A');
            }
        }
        return answer;
    }
}
