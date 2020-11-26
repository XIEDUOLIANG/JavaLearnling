package leetcode.datastructure.链表;

/**
 * @author XieDuoLiang
 * @date 2020/10/29 下午1:26
 */
public class Node {

    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", next=" + next +
                ", random=" + random +
                '}';
    }
}
