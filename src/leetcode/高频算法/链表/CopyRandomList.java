package leetcode.高频算法.链表;

import leetcode.datastructure.链表.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author XieDuoLiang
 * @date 2020/10/29 下午1:25
 */
public class CopyRandomList {

    public static void main(String[] args) {
        Node head = new Node(7);
        Node one = new Node(13);
        Node two = new Node(11);
        Node three = new Node(10);
        Node four = new Node(1);
        head.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        head.random = null;
        one.random = head;
        two.random = four;
        three.random = two;
        four.random = head;
        System.out.println(new CopyRandomList().copyRandomListByQue(head).next.random.val);
    }

    /**
     * 复制带随机指针的链表
     *
     * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
     *
     * 要求返回这个链表的 深拷贝。 
     *
     * 我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
     *
     * val：一个表示 Node.val 的整数。
     * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
     *
     * */
    //第一次遍历的时候用队列记录节点随机指针指向节点的下标（效率比较低）
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        //用一个队列记录随机指针指向的链表下标
        Queue<Integer> randomIndex = new LinkedList<>();
        Node copyHead = new Node(head.val);
        //记录头部随机指针下标
        this.addIndex(randomIndex,head,head);
        Node copy = copyHead;
        for (Node node = head.next; node != null; node = node.next) {
            copy.next = new Node(node.val);
            copy = copy.next;
            //记录随机指针下标
            this.addIndex(randomIndex,node,head);
        }
        for (Node node = copyHead; node != null; node = node.next) {
            Integer index = randomIndex.poll();
            if (index == null) {
                node.random = null;
            } else {
                //根据下标找到随机指针的指向
                Node node1 = copyHead;
                for (int i = 0; i < index; i++) {
                    node1 = node1.next;
                }
                node.random = node1;
            }
        }
        return copyHead;
    }

    public void addIndex(Queue<Integer> randomIndex,Node node,Node head) {
        int index = 0;
        boolean isNull = true;
        for (Node nodeRandom = head; nodeRandom != null; nodeRandom = nodeRandom.next) {
            if (nodeRandom == node.random) {
                randomIndex.offer(index);
                isNull = false;
                break;
            }
            index++;
        }
        if (isNull) randomIndex.offer(null);
    }

    //------------------------------------------------------------------------------
    /**
     * 老节点和新节点一一映射
     * 时间复杂度O(2n)
     * */
    public Node copyRandomListByQue(Node head) {
        if (head == null) {
            return null;
        }
        // 老节点｜新节点
        Map<Node,Node> map = new HashMap<>();
        for (Node node = head; node != null; node = node.next) {
            map.put(node,new Node(node.val));
        }
        for (Node node = head; node != null; node = node.next) {
            Node copy = map.get(node);
            copy.next = map.get(node.next);
            copy.random = map.get(node.random);
        }
        return map.get(head);
    }
}
