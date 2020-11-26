package leetcode;

import leetcode.datastructure.TreeNode;
import leetcode.enums.TreeLeftRight;

import java.util.Stack;

public class IsValidBSTSolution {

    /**
     * 三种解决方案
     * 1. isValidBST
     * 2. isValidBSTBySection
     * 3. isValidBSTByInorder
     * */
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.right = new TreeNode(30);
        treeNode.right.left = new TreeNode(10);
        treeNode.right.left.right = new TreeNode(15);
        treeNode.right.left.right.right = new TreeNode(26);
        treeNode.right.left.right.right.left = new TreeNode(24);
        treeNode.right.left.right.right.left.left = new TreeNode(20);
        treeNode.right.left.right.right.left.left.right = new TreeNode(22);
        treeNode.right.left.right.right.left.left.right.right = new TreeNode(23);
        System.out.println(isValidBSTBySection(treeNode));
    }

    /**
     * 98. 验证二叉搜索树
     * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
     *
     * 假设一个二叉搜索树具有如下特征：
     *
     * 节点的左子树只包含小于当前节点的数。
     * 节点的右子树只包含大于当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     * 示例 1:
     * 输入:
     *     2
     *    / \
     *   1   3
     * 输出: true
     * 示例 2:
     * 输入:
     *     5
     *    / \
     *   1   4
     *      / \
     *     3   6
     * 输出: false
     * 解释: 输入为: [5,1,4,null,null,3,6]。
     *      根节点的值为 5 ，但是其右子节点值为 4 。
     * */
    /*public static boolean isValidBST(TreeNode root){

    }*/

    public static boolean isValidBST(TreeNode root) {
        //递归 每个节点都验证左右子树的所有节点
        boolean left = true;
        boolean right = true;
        if(root == null){
            return true;
        }
        if(root.left != null){
            left = recursionLeft(root.left,root.val);
            left = isValidBST(root.left) && left;
        }
        if(root.right != null){
            right = recursionRight(root.right,root.val);
            right = isValidBST(root.right) && right;
        }
        return left && right;
    }

    //root是上一层的左节点，val是上一层节点的值
    public static boolean recursionLeft(TreeNode root,int val){
        if(root.val >= val){
            return false;
        }else {
            //该节点下所有节点值都小于val
            return leftDown(root,val);
        }
    }

    //所有节点的值都小于val
    public static boolean leftDown(TreeNode root,int val){
        //false的情况可以直接return，不关心是否执行后面的，为true不能直接return，后面的要执行完，除非遇到false
        boolean left = true;
        boolean right = true;
        if(root.left != null){
            if(root.left.val >= val){
                return false;
            }else {
                left = leftDown(root.left,val);
            }
        }
        if(root.right != null){
            if(root.right.val >= val){
                return false;
            }else {
                right = leftDown(root.right,val);
            }
        }
        return left && right;

    }

    //root是上一层的右节点，val是上一层节点的值
    public static boolean recursionRight(TreeNode root,int val){
        if(root.val <= val){
            return false;
        }else {
            //该节点下所有节点值都大于val
            return rightDown(root,val);
        }
    }

    //所有节点的值都大于val
    public static boolean rightDown(TreeNode root,int val){
        //false的情况可以直接return，不关心是否执行后面的，为true不能直接return，后面的要执行完，除非遇到false
        boolean left = true;
        boolean right = true;
        if(root.left != null){
            if(root.left.val <= val){
                return false;
            }else {
                left =  rightDown(root.left,val);
            }
        }
        if(root.right != null){
            if(root.right.val <= val){
                return false;
            }else {
                right = rightDown(root.right,val);
            }
        }
        return left && right;
    }

    //---------------------------------------------------------------解决方案分割线

    /**
     * 每个节点遍历一遍，时间复杂度O(n)
     *     5
     *    / \
     *   1   7
     *      / \
     *     6   8
     * 例：节点值为6的节点区间在5～7之间 ，节点值为8的节点区间在7～无穷
     * 遍历每个节点时，只关心节点的上层区间
     * */
    public static boolean isValidBSTBySection(TreeNode root){
        return recursionBySection(root,null,null);
    }

    /**
     * 递归规则：
     * 1. 进来的是根节点，则上下区间是null
     * 2. 进来的是左节点（所有上层节点无转折），lower是null，upper是上层节点的值
     * 3. 进来的是左节点（上层节点中有转折节点），lower是转折节点的上层节点的值，upper是上层节点的值
     * 4. 进来的是右节点（所有上层节点无转折），lower是上层节点的值，upper是null
     * 5. 进来的是右节点（上层节点中有转折节点），lower是上层节点的值，upper是转折节点的上层节点的值
     * */
    public static boolean recursionBySection(TreeNode node,Integer lower,Integer upper){
        boolean left = true;
        boolean right = true;
        if(node == null){
            return true;
        }
        Integer val = node.val;
        //根节点
        if(lower == null && upper == null){
            left = recursionBySection(node.left,null,val);
            right = recursionBySection(node.right,val,null);
        }
        //进来的是左节点（所有上层节点无转折）
        else if(lower == null){
            if(val >= upper){
                return false;
            }else {
                left = recursionBySection(node.left,null,val);
                right = recursionBySection(node.right,val,upper);    //upper是转折点的上层节点的值
            }
        }
        //进来的是右节点（所有上层节点无转折）
        else if(upper == null){
            if(val <= lower){
                return false;
            }else {
                left = recursionBySection(node.left,lower,val);      //lower是转折点的上层节点的值
                right = recursionBySection(node.right,val,null);
            }
        }
        //规则3和5
        else{
            if(val <= lower || val >= upper){
                return false;
            }else {
                left = recursionBySection(node.left,lower,val);
                right = recursionBySection(node.right,val,upper);
            }
        }
        return left && right;
    }

    //---------------------------------------------------------------解决方案分割线

    /**
     * 中序遍历二叉搜索树，遍历的每个节点值不能大于前面的，可以保证结果是升序
     * 规则：请画图举例，文字已经无法描述...（不能用递归中序遍历，用循环➕栈的方式中序遍历）
     * inorder是中序遍历顺序中，上个节点的值
     * */
    public static boolean isValidBSTByInorder(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        double inorder = - Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) return false;
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}


