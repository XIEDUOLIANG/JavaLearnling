package leetcode.高频算法.链表;

import leetcode.datastructure.链表.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XieDuoLiang
 * @date 2020/10/30 上午11:01
 */
public class SortList {

    public static void main(String[] args) {
        /*ListNode head = new ListNode(-1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(0);*/
        //head.next.next.next.next.next = new ListNode(-2);
        ListNode head2 = new ListNode(55);
        ListNode node = head2;
        for (int i = 0; i < 10000000; i++) {
            node.next = new ListNode((int) (Math.random()*10000000));
            node = node.next;
        }
        Long before = System.currentTimeMillis();
        head2 = new SortList().sortList1(head2);
        Long after = System.currentTimeMillis();
        /*for (ListNode listNode = head; listNode != null; listNode = listNode.next) {
            System.out.println(listNode);
        }*/
        System.out.println(after-before);
    }

    /**
     * 链表排序
     * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
     *
     * 进阶：
     *
     * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
     * */
    //在leetcode超出时间限制（长度十万的链表排序大概 49s，一万的大概 300ms）
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        List<ListNode> listNodes = new ArrayList<>();
        for (ListNode node = head; node != null; node = node.next) {
            listNodes.add(node);
        }
        for (int i = listNodes.size()-1; i > 0; i--) {
            for (int j = 0; j <= i-1; j++) {
                if (listNodes.get(j).val > listNodes.get(j+1).val){
                    ListNode temp = listNodes.get(j+1);
                    listNodes.set(j+1,listNodes.get(j));
                    listNodes.set(j,temp);
                }
            }
        }
        head = listNodes.get(0);
        ListNode node = head;
        for (int i = 1; i < listNodes.size(); i++) {
            node.next = listNodes.get(i);
            node = node.next;
        }
        node.next = null;
        return head;
    }

    //--------------------------------------------------------------------------
    /**
     * 归并 + 递归
     *
     * 时间复杂度O(n log n)：二分法分割的时候是log n，合并组成有序链表的时候是n
     * 最终结果是上面相乘，而不是相加
     *
     * 空间复杂度O(log n)：递归调用函数带来的空间
     * */
    //好像没有实现上面的时间复杂度，在leetcode战胜18% 官方实现 战胜 38%
    public ListNode sortList1(ListNode head) {
        if (head == null) {
            return null;
        }
        int size = 0;
        for (ListNode node = head; node != null; node = node.next) {
            size++;
        }
        //将链表二分法分割 然后有序地合并
        return recursion(head,size);
    }

    public ListNode recursion(ListNode head,int size) {
        if (size <= 1) {
            //System.out.println(head);   这行注释的代码可以辅助分析拆分情况
            return head;
        }
        //计算出拆分位置的坐标
        int mid = size % 2 == 0 ? size/2-1 : size/2;

        //拆分之后的长度
        int leftSize = size % 2 == 0 ? size/2 : size/2+1;
        int rightSize = size % 2 == 0 ? size/2 : size/2;

        //将链表一分为二
        ListNode nodeLeft = head;
        ListNode cut;
        for (int i = 0; i < mid; i++) {
            nodeLeft = nodeLeft.next;
        }
        cut = nodeLeft.next;
        nodeLeft.next = null;

        ListNode left = recursion(head,leftSize);
        ListNode right = recursion(cut,rightSize);

        //将两个有序链表合并为一个有序链表
        return mergeSort(left,right);
    }
    
    public ListNode mergeSort(ListNode left, ListNode right){
        ListNode sortNodeHead;
        if (left.val > right.val) {
            sortNodeHead = new ListNode(right.val);
            right = right.next;
        } else {
            sortNodeHead = new ListNode(left.val);
            left = left.next;
        }
        ListNode sortNode = sortNodeHead;
        while (left != null || right != null) {
            if (left != null && right != null) {
                if (left.val > right.val) {
                    sortNode.next = new ListNode(right.val);
                    right = right.next;
                } else {
                    sortNode.next = new ListNode(left.val);
                    left = left.next;
                }
                sortNode = sortNode.next;
            } else {
                while (right != null) {
                    sortNode.next = new ListNode(right.val);
                    sortNode = sortNode.next;
                    right = right.next;
                }
                while (left != null) {
                    sortNode.next = new ListNode(left.val);
                    sortNode = sortNode.next;
                    left = left.next;
                }
            }
        }
        return sortNodeHead;
    }
}
