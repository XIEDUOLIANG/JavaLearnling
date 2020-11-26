package leetcode.动态规划;

import java.util.HashMap;
import java.util.Map;

/**
 * @author XieDuoLiang
 * @date 2020/11/8 下午8:25
 */
public class SuperEggDrop {

    public static void main(String[] args) {
        System.out.println(new SuperEggDrop().superEggDrop(2,6));
    }

    /**
     * 鸡蛋掉落问题 谷歌经典的面试题
     *
     * 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
     *
     * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
     *
     * 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
     *
     * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
     *
     * 你的目标是确切地知道 F 的值是多少。
     *
     * 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
     *
     * 示例 1：
     *
     * 输入：K = 1, N = 2
     * 输出：2
     * 解释：
     * 鸡蛋从 1 楼掉落。如果它碎了，我们肯定知道 F = 0 。
     * 否则，鸡蛋从 2 楼掉落。如果它碎了，我们肯定知道 F = 1 。
     * 如果它没碎，那么我们肯定知道 F = 2 。
     * 因此，在最坏的情况下我们需要移动 2 次以确定 F 是多少。
     * 示例 2：
     *
     * 输入：K = 2, N = 6
     * 输出：3
     * 示例 3：
     *
     * 输入：K = 3, N = 14
     * 输出：4
     * */
    public int superEggDrop(int K, int N) {
        return dp(K,N);
    }

    /**
     * 动态规划 + 二分查找
     * dp(K,N)=1 + min(max(dp(K−1,X−1),dp(K,N−X)))
     *                          1≤X≤N       1≤X≤N
     * 时间复杂度O(KN logN)
     * */
    Map<Integer,Integer> map = new HashMap<>();
    public int dp(int K, int N) {
        if (!map.containsKey(N * 100 + K)) {    //为什么是N * 100 + k 而不是 K * 100 + N
            int answer;
            if (N == 0) {
                return 0;
            }
            else if (K == 1) {
                return N;
            }
            else {
                int low = 1, high = N;
                while (low + 1 < high) {
                    int X = (low + high) >> 1;
                    int t1 = dp(K-1,X - 1); //随X单调递增
                    int t2 = dp(K,N - X); //随X单调递减

                    if (t1 < t2) {
                        low = X;
                    }
                    else if (t1 > t2) {
                        high = X;
                    }
                    else {
                        low = high = X;
                    }
                }
                answer = 1 + Math.min(
                        Math.max(dp(K - 1,low - 1),dp(K,N-low)),
                        Math.max(dp(K - 1,high - 1),dp(K,N - high))
                );
            }
            map.put(N * 100 + K,answer);
        }
        return map.get(N * 100 + K);
    }
}
