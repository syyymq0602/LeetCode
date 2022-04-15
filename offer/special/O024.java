package offer.special;

import LL.scripts.ListNode;
import LL.scripts.ListNodeUtils;

/**
 * 剑指 Offer II 024. 反转链表
 *
 * 给定单链表的头节点 head ，请反转链表，并返回反转后的链表的头节点
 *
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 */
public class O024 {
    public static void main(String[] args) {
        var node = ListNodeUtils.generateByArray(new int[]{1,2,3,4,5});
        var ans = reverseList(node);
    }

    private static ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur!=null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
