package offer.special;

import LL.scripts.ListNode;
import LL.scripts.ListNodeUtils;

import java.util.ArrayList;
import java.util.List;

import static offer.special.O077.sortList;

/**
 * 剑指 Offer II 078. 合并排序链表
 *
 * 给定一个链表数组，每个链表都已经按升序排列。
 * 请将所有链表合并到一个升序链表中，返回合并后的链表
 *
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 */
public class O078 {
    public static void main(String[] args) {
        var l1 = ListNodeUtils.generateByArray(new int[]{1,4,5});
        var l2 = ListNodeUtils.generateByArray(new int[]{1,3,4});
        var l3 = ListNodeUtils.generateByArray(new int[]{2,6});
        var lists = new ListNode[]{l1,l2,l3};
        var ans = mergeKLists(lists);
        System.out.println(ans.val);
    }

    private static ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        for (int i = 0; i < lists.length; ++i) {
            ans = mergeTwoLists(ans, lists[i]);
        }
        return ans;
    }

    public static ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
    }
}
