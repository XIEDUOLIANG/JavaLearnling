package leetcode.高频算法.排序与检索;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author XieDuoLiang
 * @date 2020/11/4 下午2:17
 */
public class LargestNumber {

    //判断int有几位
    final static int[] sizeTable = { 9, 99, 999, 9999, 99999, 999999, 9999999,
            99999999, 999999999, Integer.MAX_VALUE };
    static int sizeOfInt(int x) {
        for (int i = 0;; i++)
            if (x <= sizeTable[i])
                return i + 1;
    }

    public static void main(String[] args) {
        //System.out.println(sizeOfInt(12367));

        /*int[] nums =  new int[50000000];
        for (int i = 0; i < 50000000; i++) {
            nums[i] = i;
        }
        Long before = System.currentTimeMillis();
        new LargestNumber().largestNumber(nums);
        Long after = System.currentTimeMillis();
        System.out.println((double) (after - before) / 1000);*/

        System.out.println(3 >> 1);
    }

    /**
     * 最大数
     *
     * 给定一组非负整数 nums，重新排列它们每位数字的顺序使之组成一个最大的整数。
     * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
     * */
    public String largestNumber(int[] nums) {
        String[] numsStr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsStr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numsStr, new LargestNumerComparator());

        if (numsStr[0].equals("0")) {
            return "0";
        }

        StringBuilder answer = new StringBuilder();
        for (String num : numsStr) {
            answer.append(num);
        }
        return answer.toString();
    }
    
    private class LargestNumerComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            String order1 = o1+o2;
            String order2 = o2+o1;
            return order2.compareTo(order1);
        }
    }

    //----------------------------------------------------------------

    /**
     *
     * */
    public String largestNumber1(int[] nums) {
        StringBuilder sb = new StringBuilder();

        for (String s :
                Arrays.stream(nums)
                        .boxed()
                        .map(Object::toString)
                        .sorted((o1, o2) -> (o2 + o1).compareTo(o1 + o2))
                        .collect(Collectors.toList())) {
            sb.append(s);
        }

        String result = sb.toString();

        return result.startsWith("0") ? "0" : result;
    }

    public String largestNumber2(int[] nums) {
        String result = IntStream.of(nums)
                .mapToObj(String::valueOf)
                .sorted(((o1, o2) -> (o2 + o1).compareTo(o1 + o2)))
                .collect(Collectors.joining());
        return result.startsWith("0") ? "0" : result;
    }

}
