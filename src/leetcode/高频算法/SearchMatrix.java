package leetcode.高频算法;

/**
 * @author XieDuoLiang
 * @date 2020/10/28 上午9:57
 */
public class SearchMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,4,7},
                {2,5,8},
                {3,6,9}
        };
        System.out.println(new SearchMatrix().searchMatrix(matrix,5));
    }

    /**
     * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
     *
     * 每行的元素从左到右升序排列。
     * 每列的元素从上到下升序排列。
     * [
     *   [1,   4,  7, 11, 15],
     *   [2,   5,  8, 12, 19],
     *   [3,   6,  9, 16, 22],
     *   [10, 13, 14, 17, 24],
     *   [18, 21, 23, 26, 30]
     * ]
     * 给定 target = 5，返回 true。
     *
     * 给定 target = 20，返回 false。
     * */
    public boolean searchMatrix(int[][] matrix, int target) {
        int col = matrix.length-1;
        int row = 0;
        while (col >= 0 && row < matrix[0].length) {
            if (target < matrix[col][row]) {
                col--;
            }
            else if (target > matrix[col][row]) {
                row++;
            } else {
                return true;
            }
        }
        return false;
    }
}
