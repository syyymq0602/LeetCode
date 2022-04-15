package offer.special;

import LL.scripts.ListNode;
import LL.scripts.ListNodeUtils;

/**
 * 剑指 Offer II 021. 删除链表的倒数第 n 个结点
 *
 * 给定一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点
 *
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 */
public class O021 {
    public static void main(String[] args) {
        var node = ListNodeUtils.generateByArray(new int[]{1,2,3,4,5});
        var res = removeNthFromEnd(node,2);
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ans = new ListNode(-1, head);
        ListNode first = head;
        ListNode second = ans;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return ans.next;
    }
}
