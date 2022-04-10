package LL.scripts;

import java.util.ArrayList;
import java.util.List;

import static LL.scripts.ListNodeUtils.generateByArray;


/**
 * 206. 反转链表
 *
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 */
public class LL206 {
    public static void main(String[] args) {
        var l1 = generateByArray(new int[]{1,2,3,4,6});
        ListNode node = reverseList1(l1);
        System.out.println();
    }

    private static ListNode reverseList(ListNode head) {
        List<Integer> temp = new ArrayList<>();
        reverseList(head,temp);
        ListNode res = new ListNode(-1);
        ListNode tail = res;
        int index = 0;
        while (index < temp.size()){
            tail.next = new ListNode(temp.get(index));
            tail = tail.next;
            index++;
        }
        return res.next;
    }

    private static void reverseList(ListNode head, List<Integer> temp) {
        if(head == null){
            return;
        }
        reverseList(head.next,temp);
        temp.add(head.val);
    }

    private static ListNode reverseList1(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
