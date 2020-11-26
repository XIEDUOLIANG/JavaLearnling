package leetcode.二叉树;

import leetcode.datastructure.Node;
import leetcode.datastructure.TreeNode;

import java.util.Objects;

/**
 * @author XieDuoLiang
 * @date 2020/10/27 上午10:09
 */
public class LowestCommonAncestor {

    private TreeNode ans;

    public LowestCommonAncestor(){
        this.ans = null;
    }

    public static void main(String[] args) {

        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.left.left = new Node(0);
        root1.left.left.left = new Node(2);
        root1.left.right = new Node(7);
        root1.left.right.left = new Node(1);
        root1.left.right.right = new Node(0);
        root1.left.right.right.left = new Node(7);

        root1.right = new Node(3);
        root1.right.left = new Node(9);
        root1.right.right = new Node(1);
        root1.right.right.left = new Node(8);
        root1.right.right.right = new Node(8);
    }

    /**
     * 二叉树的最近公共祖先
     * */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.recursion(root,p,q);
        return ans;
    }

    public boolean recursion(TreeNode root,TreeNode p,TreeNode q){
        if (Objects.isNull(root)) return false;

        boolean lson = recursion(root.left,p,q);
        boolean rson = recursion(root.right,p,q);
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            this.ans = root;
        }

        return lson || rson || (root.val == p.val || root.val == q.val);
    }
}
