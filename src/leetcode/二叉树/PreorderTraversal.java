package leetcode.二叉树;

import leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树遍历
 *
 * @author XieDuoLiang
 * @date 2020/10/16 下午3:48
 */
public class PreorderTraversal {

    public static void main(String[] args) {
        //前中后序遍历
        /*TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> integers = traversal(root);
        System.out.println(integers);*/

        //层序遍历
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(levelOrder(root));
    }

    /**
     * 遍历二叉树
     * */
    public static List<Integer> traversal(TreeNode root){

        List<Integer> order = new ArrayList<>();
        //recursionPre(preorder,root);
        //iterationIn(preorder,root);
        //iterationPre(order,root);
        recursionPost(order,root);
        return order;
    }

    /**
     * 前序递归遍历
     * */
    public static void recursionPre(List<Integer> preorder,TreeNode root){
        if(Objects.nonNull(root)){
            preorder.add(root.val);
            recursionPre(preorder,root.left);
            recursionPre(preorder,root.right);
        }
    }

    /**
     * 后序递归遍历
     * */
    public static void recursionPost(List<Integer> postOrder,TreeNode root){
        if (Objects.nonNull(root)) {
            recursionPost(postOrder,root.left);
            recursionPost(postOrder,root.right);
            postOrder.add(root.val);
        }
    }

    /**
     * 前序遍历迭代算法（栈实现）
     * */
    public static void iterationPre(List<Integer> preorder,TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || Objects.nonNull(root)) {
            while (Objects.nonNull(root)) {
                stack.push(root);
                preorder.add(root.val);
                root = root.left;
            }

            TreeNode temp = stack.pop();
            root = temp.right;
        }
    }

    /**
     * 中序遍历迭代算法（栈实现）
     * */
    public static void iterationIn(List<Integer> Inorder,TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || Objects.nonNull(root)) {
            while (Objects.nonNull(root)) {
                stack.push(root);
                root = root.left;
            }

            TreeNode temp = stack.pop();
            Inorder.add(temp.val);
            root = temp.right;
        }
    }

    /**
     * 广度优先搜索二叉树
     * 层序遍历（队列实现）
     * */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrder = new ArrayList<>();
        if (Objects.nonNull(root)) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                List<Integer> inner = new ArrayList<>();
                int levelLength = queue.size();
                for (int i = 0; i < levelLength; i++) {
                    TreeNode treeNode = queue.poll();
                    inner.add(treeNode.val);
                    if(Objects.nonNull(treeNode.left)) queue.offer(treeNode.left);
                    if(Objects.nonNull(treeNode.right)) queue.offer(treeNode.right);
                }
                levelOrder.add(inner);
            }
        }
        return levelOrder;
    }

}
