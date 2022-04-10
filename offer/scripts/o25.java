package offer.scripts;

import LL.scripts.ListNode;

import static LL.scripts.ListNodeUtils.generateByArray;

/**
 * 剑指 Offer 25. 合并两个排序的链表
 *
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的
 *
 * 0 <= 链表长度 <= 1000
 */
public class o25 {
    public static void main(String[] args) {
        var l1 = generateByArray(new int[]{1,3,4});
        var l2 = generateByArray(new int[]{1,2,3});
        var ans = mergeTwoLists(l1,l2);
        System.out.println();
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode cur = new ListNode(-1);
        ListNode ans = cur;
        while (l1 !=null && l2 != null){
            if(l1.val <= l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1!=null?l1:l2;
        return ans.next;
    }
}
