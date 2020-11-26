package leetcode.二叉树;

import leetcode.datastructure.TreeNode;

import java.util.Objects;
import java.util.Stack;

/**
 * @author XieDuoLiang
 * @date 2020/10/18 下午10:27
 */
public class PathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(5);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        /*root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.left.left = new TreeNode(5);*/
        System.out.println(recursion(root,36));
    }

    /**
     * todo 有点缺陷，待完善
     *
     * 中序遍历二叉树（迭代法）
     * 1. 压入栈，直到是叶子节点为止，比较路径和
     * 2. 进入右节点之后，要把右节点最后遍历的路径值保存下来，后一步减去该值
     * */
    public static boolean hasPathSum(TreeNode root,int sum){
        Stack<TreeNode> stack = new Stack<>();
        int tempSum = 0;
        int leftSub = 0;     //需要减去的值
        TreeNode node = null;
        while (!stack.isEmpty() || Objects.nonNull(root)) {
            boolean canSub = true;
            while (Objects.nonNull(root)) {
                tempSum += root.val;
                stack.push(root);
                root = root.left;
                canSub = false;
            }
            if (Objects.nonNull(node) && Objects.nonNull(node.left) && Objects.nonNull(node.left.right)) {
                System.out.println(tempSum);
                System.out.println(node.left.val);
                System.out.println(subRight(node.left.right,0));
                tempSum = tempSum - node.left.val - subRight(node.left.right,0);
                System.out.println(tempSum); // todo 与预期相差5
            }
            node = stack.pop();
            if (Objects.isNull(node.right) && Objects.isNull(node.left) && tempSum == sum) return true;
            if (canSub) {
                tempSum = tempSum - leftSub;
            }
            if (Objects.isNull(node.right)) {
                leftSub = node.val;
            }
            root = node.right;
        }
        return false;
    }

    public static int subRight(TreeNode root,int sum) {
        if (Objects.nonNull(root)) {
            if (Objects.isNull(root.right)) {
                if (Objects.nonNull(root.left)) {
                    sum = subRight(root.left,sum);
                }
            } else {
                sum = subRight(root.right,sum);
            }
            sum += root.val;
        }

        return sum;
    }

    //---------------------------------------------------------------------------------------------

    /**
     * 递归
     * */
    public static boolean recursion(TreeNode root,int sum){
        if (Objects.nonNull(root)) {
            sum = sum - root.val;
            if (Objects.isNull(root.left) && Objects.isNull(root.right)) {
                if(sum == 0) return true;
            }
            return recursion(root.left,sum) || recursion(root.right,sum);
        }
        return false;
    }
}
