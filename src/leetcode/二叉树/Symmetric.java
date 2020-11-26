package leetcode.二叉树;

import leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 对称二叉树
 *
 * @author XieDuoLiang
 * @date 2020/10/18 下午5:28
 */
public class Symmetric {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(20);
        root.right = new TreeNode(20);
        //root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(7);
        //root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(isSymmetric(root));
    }

    public static boolean isSymmetric(TreeNode root){
        if (Objects.isNull(root)) {
            return true;
        }
        if (Objects.isNull(root.left) && Objects.isNull(root.right)) {
            return true;
        }
        List<TreeNode> left = new ArrayList<>();
        List<TreeNode> right = new ArrayList<>();
        //根 左 右
        recursionLeft(root.left,left);
        //根 右 左
        recursionRight(root.right,right);
        int leftSize = left.size();
        int rightSize = right.size();
        if(leftSize != rightSize){
            return false;
        }else {
            for (int i = 0; i < leftSize; i++) {
                if(Objects.nonNull(left.get(i)) && Objects.nonNull(right.get(i))){
                    if(left.get(i).val != right.get(i).val) return false;
                }else {
                    if (!(Objects.isNull(left.get(i)) && Objects.isNull(right.get(i)))) return false;
                }
            }
        }
        return true;
    }

    public static void recursionLeft(TreeNode root,List<TreeNode> nodeList){
        nodeList.add(root);
        if(Objects.nonNull(root)){
            recursionLeft(root.left,nodeList);
            recursionLeft(root.right,nodeList);
        }
    }

    public static void recursionRight(TreeNode root,List<TreeNode> nodeList){
        nodeList.add(root);
        if(Objects.nonNull(root)){
            recursionRight(root.right,nodeList);
            recursionRight(root.left,nodeList);
        }
    }
}
