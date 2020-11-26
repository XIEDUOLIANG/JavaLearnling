package leetcode.二叉树;

import leetcode.datastructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author XieDuoLiang
 * @date 2020/10/22 上午9:00
 */
public class PreorderAndIn {

    private int[] preorder;
    private int[] inorder;
    private int pre_index;
    private Map<Integer,Integer> map_index = new HashMap<>();

    public static void main(String[] args) {

    }

    /**
     * 根据前序和中序构造二叉树
     * */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;

        //从前序的第一个根节点开始
        pre_index = 0;

        //映射值的下标
        int index = 0;
        for (int val:inorder) {
            map_index.put(val,index++);
        }

        return recursion(0,inorder.length-1);
    }

    public TreeNode recursion(int in_left,int in_right){
        //如果长度为0，则结束构造
        if (in_left > in_right) {
            return null;
        }

        //找到根节点的下标，分成左右子树，并构建根节点
        int rootVal = preorder[pre_index];
        TreeNode root = new TreeNode(rootVal);
        int index = map_index.get(rootVal);

        //前序的下标往后推进（每次推进的节点都可以看作根节点）
        pre_index++;

        root.left = recursion(in_left,index-1);
        root.right = recursion(index+1,in_right);
        return root;
    }
}
