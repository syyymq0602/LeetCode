package LL.scripts;

import static LL.scripts.LL2.generateByArray;

/**
 * 876. 链表的中间结点
 *
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 * 给定链表的结点数介于 1 和 100 之间
 */
public class LL876 {
    public static void  main(String[] args) {
        var head = generateByArray(new int[]{1,2,3,5,6});
        ListNode node = middleNode(head,2);
    }

    private static ListNode middleNode(ListNode head) {
        ListNode temp = head;
        int total = 0;
        while (temp!=null){
            temp = temp.next;
            total++;
        }
        int mid = total/2;
        int index = 0;
        while (index<mid){
            head = head.next;
            index++;
        }
        return head;
    }

    private static ListNode middleNode(ListNode head,int n) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
