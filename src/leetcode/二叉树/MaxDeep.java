package leetcode.二叉树;

import leetcode.datastructure.TreeNode;

import java.util.Objects;
import java.util.Stack;

/**
 * 二叉树最大深度
 *
 * @author XieDuoLiang
 * @date 2020/10/17 上午10:11
 */
public class MaxDeep {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        //System.out.println(maxDeep(root));
        System.out.println(new MaxDeep().maxDeepRecursion(root,0));
    }

    /**
     * 二叉树最大深度（栈实现）
     * */
    public static int maxDeep(TreeNode root){
        int answer = 0;
        int deep = 0;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> deepStack = new Stack<>();
        while (!stack.isEmpty() || Objects.nonNull(root)) {
            while (Objects.nonNull(root)) {
                deepStack.push(++deep);
                stack.push(root);
                root = root.left;
            }
            deep = deepStack.pop();
            answer = Math.max(answer,deep);
            root = stack.pop();
            root = root.right;
        }
        return answer;
    }

    private int answer = 0;

    /**
     * 二叉树最大深度（递归 自顶向下）
     * */
    public int maxDeepRecursion(TreeNode root,int deep) {
        if (Objects.nonNull(root)) {
            answer = Math.max(answer,++deep);
            maxDeepRecursion(root.left,deep);
            maxDeepRecursion(root.right,deep);
        }
        return answer;
    }

    /**
     * 二叉树最大深度（递归 自底向上）
     * */
    public int maxDeepFromBottom(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left_depth = maxDeepFromBottom(root.left);
        int right_depth = maxDeepFromBottom(root.right);
        return Math.max(left_depth, right_depth) + 1;
    }
}
