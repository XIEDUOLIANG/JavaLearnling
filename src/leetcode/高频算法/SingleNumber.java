package leetcode.高频算法;

/**
 * @author XieDuoLiang
 * @date 2020/10/21 下午4:32
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = new int[]{5,2,3,2,6,5,3,1,6};
        System.out.println(new SingleNumber().singleNumber(nums));
        /**
         * 异或运算
         * 00000001 -> 1
         *
         * 00000101 -> 5
         *
         * 上面两个数字的异或结果
         * 00000100 -> 4
         * */
        int i = 1;
        i ^= 5;
        System.out.println(i);
    }

    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素
     * 输入: [2,2,1]
     * 输出: 1
     * 1. 应该具有线性时间复杂度
     * 2. 尽量不使用额外空间
     * */
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num:nums) {
            single ^= num;
        }
        return single;
    }
}
