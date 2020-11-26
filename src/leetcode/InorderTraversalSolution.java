package leetcode;

import leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversalSolution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(inorderTraversal(root));
    }

    /**
     * 94.二叉树中序遍历
     * */
    public static List<Integer> inorderTraversal(TreeNode root){
        List<Integer> inorder = new ArrayList<>();
        if(root == null){
            return inorder;
        }
        recursion(root,inorder);
        return inorder;
    }

    static void recursion(TreeNode root,List<Integer> inorder){
        if(root.left != null){
            recursion(root.left,inorder);
        }
        inorder.add(root.val);
        if(root.right != null){
            recursion(root.right,inorder);
        }
    }
}
