package leetcode;

import leetcode.datastructure.ListNode;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RemoveNthFromEndSolution {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode head = listNode;
        for (int i = 2; i < 100000000 ; i++) {
            listNode.next = new ListNode(i);
            listNode = listNode.next;
        }
        System.out.println(new SimpleDateFormat("mm:ss:SSS").format(new Date()));
        head = removeNthFromEndByOneTime(head,5);
        System.out.println(new SimpleDateFormat("mm:ss:SSS").format(new Date()));
        head = removeNthFromEnd(head,5);
        System.out.println(new SimpleDateFormat("mm:ss:SSS").format(new Date()));
        /*for( ; head != null ; head = head.next){
            System.out.println(head.val);
        }*/
    }

    /**
     * 19. 删除链表的倒数第N个节点
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点
     * */
    /*给定一个链表: 1->2->3->4->5, 和 n = 2.

    当删除了倒数第二个节点后，链表变为 1->2->3->5.*/
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //遍历链表，得到长度
        int length = 0;
        for(ListNode node = head ; node != null ; node = node.next){
            length++;
        }
        //删除倒数第n个节点，就是正数第（length-n+1）个节点,将第（length-n）节点指向下下个节点
        ListNode node = head;
        for(int i = 1 ; i<=length ; i++,node = node.next ){
            //第（length-n）节点指向下下个节点                                   ------第一种情况
            if(i == length-n){
                node.next = node.next.next;
                break;
            }
            //删除的节点刚好是头部节点的情况，且链表长度 >= 2 ,将头部指向下个节点      ------第二种情况
            else if(length-n == 0 && length >= 2){
                head = node.next;
                break;
            }
            //删除的节点刚好是头部节点的情况，且链表长度 = 1 ,头部指向空              ------第三种情况
            else if(length-n == 0){
                head = null;
                break;
            }
        }
        return head;
    }

    /**
     * 一次扫描删除倒数第n个
     * */
    public static ListNode removeNthFromEndByOneTime(ListNode head,int n){
        //两个指针，第一个指针先走，走到第n个，第二个指针开始走，这时两个指针间隔不变，直到第一个指针指向空，第二个指针指向的就是要删除的节点
        ListNode first = head;
        ListNode second = head;
        boolean isDeleteHead = false;
        int flag = 0;
        for(int i=0 ; first.next != null ; i++,flag++,first=first.next){
            if(i >= n){
                second=second.next;
            }
        }
        //1. 如果不删除头部flag和n刚好相等 2. 如果删除头部，flag和n相差1
        if(n-flag == 1){
            isDeleteHead = true;
        }
        //特殊情况1，链表长度 1 ,不会进入上面循环中的if
        if(head.next == null){
            return null;
        }
        //特殊情况2，如是删除头部，则需要特殊标示来计算，
        if(isDeleteHead){
            return head.next;
        }
        second.next = second.next.next;
        return head;
    }
}
