package leetcode.二叉树;

import leetcode.datastructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 中序和后序构造二叉树
 *
 * @author XieDuoLiang
 * @date 2020/10/21 上午9:22
 */
public class InorderAndPost {

    int[] inorder;
    int[] postorder;
    int post_index;
    Map<Integer,Integer> map_index = new HashMap<>();

    /**
     * 中序遍历 inorder = [9,3,15,20,7]
     * 后序遍历 postorder = [9,15,7,20,3]
     * 假设没有重复的值
     * */
    public static void main(String[] args) {
        int[] inorder = new int[]{9,3,15,20,7};
        int[] postorder = new int[]{9,15,7,20,3};
        System.out.println(new InorderAndPost().buildTree(inorder,postorder));
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        this.inorder = inorder;
        this.postorder = postorder;

        //映射值的下标
        int index = 0;
        for (int val:inorder) {
            map_index.put(val,index++);
        }

        //从后序的最后一个开始
        post_index = postorder.length-1;

        return recursion(0,inorder.length-1);
    }

    public TreeNode recursion(int in_left,int in_right){
        //没有长度了，就结束构造
        if (in_left > in_right) {
            return null;
        }

        //构造根节点
        int rootVal = postorder[post_index];
        TreeNode root = new TreeNode(rootVal);

        //后序中根节点向前移动 （后序中每个点都可以认作根节点）
        post_index--;

        //找到中序对应的根节点下标 分成左右两颗子树
        int index = map_index.get(rootVal);
        //先构造右子树（因为后序中，从最后向前推进，是右子树再到左子树）
        root.right = recursion(index+1,in_right);
        //再构造左子树
        root.left = recursion(in_left,index-1);

        return root;
    }

    //---------------------------------------------------------------------------------

    /**
     * 迭代法构造二叉树 todo
     * */
    
}
