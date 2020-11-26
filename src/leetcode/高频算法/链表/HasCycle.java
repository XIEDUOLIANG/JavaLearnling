package leetcode.高频算法.链表;

import leetcode.datastructure.链表.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author XieDuoLiang
 * @date 2020/10/29 下午5:02
 */
public class HasCycle {

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode node = head;
        for (int i = 0; i < 100000; i++) {
            node.next = new ListNode(i+1);
            node = node.next;
        }
        node.next = head;
        Long before = System.currentTimeMillis();
        System.out.println(new HasCycle().hasCycle2(head));
        Long after = System.currentTimeMillis();
        System.out.println(after-before);
    }

    public boolean hasCycle(ListNode head) {
        Map<ListNode,Boolean> map = new HashMap<>();
        for (ListNode node = head; node != null; node = node.next) {
            if (map.get(node) == null) {
                map.put(node,true);
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle1(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        while (head != null) {
            if (!seen.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 快慢指针
     * 原理：慢指针每次移动一步，快指针每次移动两步
     *      快慢指针最终都会走到环上，在环上的距离
     *      会随着每次的移动逐渐减少，最终相遇
     * */
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode low = head;
        ListNode fast = head.next;
        while (low != fast) {
            //判断 fast.next为null的原因：保证下面的fast.next.next不会报空指针异常
            if (fast == null || fast.next == null) {
                return false;
            }
            low = low.next;
            fast = fast.next.next;
        }
        return true;
    }
}
