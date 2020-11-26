package leetcode.二叉树;

import leetcode.datastructure.TreeNode;

import java.util.Stack;

/**
 * @author XieDuoLiang
 * @date 2020/11/4 上午10:59
 */
public class KthSmallest {

    public static void main(String[] args) {

    }

    /**
     * 二叉搜索树中第K小的元素
     * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素
     * 进阶：
     * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
     * */
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (k-- == 1) return root.val;
            root = root.right;
        }
        return 0;
    }
    
    //-----------------------------------------------------------------

    private int m = 0;
    private int answer = 0;
    /**
     * 递归 + 成员变量
     * 该解法比上面的迭代法效率高
     * */
    public int kthSmallest1(TreeNode root, int k) {
        if (root.left != null) {
            answer = kthSmallest1(root.left,k);
        }
        m++;
        if (m == k) return root.val;
        if (root.right != null) {
            answer = kthSmallest1(root.right,k);
        }
        return answer;
    }
}
