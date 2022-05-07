package offer.special;

import LL.scripts.ListNode;
import LL.scripts.ListNodeUtils;

/**
 * 剑指 Offer II 077. 链表排序
 * <p>
 * 给定链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表
 * <p>
 * 链表中节点的数目在范围 [0, 5 * 10e4] 内
 * -10e5 <= Node.val <= 10e5
 */
public class O077 {
    public static void main(String[] args) {
        var head = ListNodeUtils.generateByArray(new int[]{-1, 5, 3, 4, 0});
        var ans = sortList(head);
        System.out.println(ans.val);
    }

    public static ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public static ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return null;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        ListNode sorted = merge(list1, list2);
        return sorted;
    }

    public static ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }
}
