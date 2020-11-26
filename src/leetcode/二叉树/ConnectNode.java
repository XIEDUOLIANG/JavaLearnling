package leetcode.二叉树;

import leetcode.datastructure.Node;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * @author XieDuoLiang
 * @date 2020/10/22 上午9:36
 */
public class ConnectNode {

    /**
     * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点
     * 填充每个节点的下一个右侧节点指针
     * */
    public static void main(String[] args) {

        //完美二叉树
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        //错误案例二叉树
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

        new ConnectNode().recursionNoPerfect(root1);
        System.out.println(root1.right.left.next.val);
        //System.out.println(new ConnectNode().recursion(root1).left.right.next.val);
    }

    /**
     * 广度优先搜索（队列实现）
     * 空间：O(n) n是二叉树的节点数
     * 时间：
     * */
    public Node connect(Node root){
        if (Objects.isNull(root)) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        //放入第一个根节点，作为启动项
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node rightNode = null;
            //二叉树每层的节点数量
            int size = queue.size();

            while (!queue.isEmpty()) {
                Node temp = queue.poll();
                //将 出 队列节点的左右节点 入 队列（一定是右节点先入队列）
                if (Objects.nonNull(temp.right)) {
                    queue.offer(temp.right);
                }
                if (Objects.nonNull(temp.left)) {
                    queue.offer(temp.left);
                }

                //根据二叉树每层的右节点先入队列，则后出 队列的节点 指向 先出队列的节点，实现每层左 依次指向 右
                temp.next = rightNode;
                rightNode = temp;

                //每层的所有节点出队列之后，就跳出循环
                if (--size == 0) {
                    break;
                }
            }

        }
        return root;
    }

    //---------------------------------------------------------------------------------

    /**
     * 递归 前序遍历（完美二叉树）
     * */
    public Node recursion(Node root){
        if (Objects.isNull(root)) return null;

        if (Objects.nonNull(root.left)) {
            root.left.next = root.right;
        }
        if (Objects.nonNull(root.next) && Objects.nonNull(root.right)) {
            root.right.next = root.next.left;
        }
        recursion(root.left);
        recursion(root.right);

        return root;
    }

    /**
     * 递归 前序遍历（不完美二叉树）
     * */
    public Node recursionNoPerfect(Node root){
        if (Objects.isNull(root)) return null;

        if (Objects.nonNull(root.left)) {
            if (Objects.nonNull(root.right)) {
                root.left.next = root.right;
            } else {
                Node temp = root.next;
                while (true) {
                    if (Objects.nonNull(temp)) {
                        if (Objects.nonNull(temp.left)) {
                            root.left.next = temp.left;
                            break;
                        }
                        else if (Objects.nonNull(temp.right)) {
                            root.left.next = temp.right;
                            break;
                        } else {
                            //root.next = root.next.next; 逻辑错误，导致上层指针丢失
                            temp = temp.next;
                        }
                    } else break;
                }
            }

        }
        if (Objects.nonNull(root.right)) {
            Node temp = root.next;
            while (true) {
                if (Objects.nonNull(temp)) {
                    if (Objects.nonNull(temp.left)) {
                        root.right.next = temp.left;
                        break;
                    }
                    else if (Objects.nonNull(temp.right)) {
                        root.right.next = temp.right;
                        break;
                    } else {
                        //root.next = root.next.next; 逻辑错误，导致上层指针丢失
                        temp = temp.next;
                    }
                } else break;
            }

        }
        //一定要先右 后左！！！ 不然会导致右子树的同层指针还没出现，左子树找不到上层需要的指针
        recursionNoPerfect(root.right);
        recursionNoPerfect(root.left);

        return root;
    }

}
