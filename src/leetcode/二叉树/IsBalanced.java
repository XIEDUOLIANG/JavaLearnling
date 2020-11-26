package leetcode.二叉树;

import leetcode.datastructure.TreeNode;

/**
 * @author XieDuoLiang
 * @date 2020/11/6 上午9:37
 */
public class IsBalanced {

    public static void main(String[] args) {
        
    }

    /**
     * 平衡二叉树
     *
     * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
     * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15  7
     *    true
     *
     *        1
     *       / \
     *      2  2
     *     / \
     *    3  3
     *   / \
     *  4  4
     *    false
     * */
    //后序遍历 + 枝剪
    public boolean isBalanced(TreeNode root) {
        return recursion(root) != -1;
    }

    private boolean flag = true;

    /**
     * 一个节点的深度 = Max(左子树,右子树) + 1
     * 如果 abs(左子树,右子树) > 1 就说明不是平衡树
     * */
    public int recursion(TreeNode root) {
        int max = 0;
        if (root == null) {
            return max;
        }
        int left = recursion(root.left);
        int right = recursion(root.right);

        if (Math.abs(left - right) > 1) flag = false;

        max = Math.max(left, right) + 1;
        if (!flag) {
            max = -1;
        }
        return max;
    }
}
