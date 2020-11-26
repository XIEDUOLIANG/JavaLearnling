package leetcode.高频算法;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * @author XieDuoLiang
 * @date 2020/10/28 上午9:30
 */
public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,2,1,1,2,2,2,2};
        System.out.println(new MajorityElement().majorityElement(nums));
    }

    /**
     * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
     *
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     * */
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i:nums) {
            map.put(i, Objects.isNull(map.get(i)) ? 1 : map.get(i)+1);
        }
        Set<Integer> set = map.keySet();
        for (Integer key:set) {
            if (map.get(key) > nums.length/2) {
                return key;
            }
        }
        return 0;
    }
}
