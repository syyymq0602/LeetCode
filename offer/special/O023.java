package offer.special;

import LL.scripts.ListNode;
import LL.scripts.ListNodeUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer II 023. 两个链表的第一个重合节点
 *
 * 给定两个单链表的头节点 headA 和 headB ，请找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null
 *
 * listA 中节点数目为 m
 * listB 中节点数目为 n
 * 0 <= m, n <= 3 * 10e4
 * 1 <= Node.val <= 10e5
 * 0 <= skipA <= m
 * 0 <= skipB <= n
 * 如果 listA 和 listB 没有交点，intersectVal 为 0
 * 如果 listA 和 listB 有交点，intersectVal == listA[skipA + 1] == listB[skipB + 1]
 */
public class O023 {
    public static void main(String[] args) {
        var n1 = ListNodeUtils.generateByArray(new int[]{4,1,8,4,5});
        var n2 = ListNodeUtils.generateByArray(new int[]{5,0,1});
        var t1 = n1;
        while (t1.val!=8){
            t1 = t1.next;
        }
        var t2 = n2;
        while (t2.next != null){
            t2 = t2.next;
        }
        t2.next = t1;
        var node = getIntersectionNode(n1, n2);
        System.out.println();
    }

    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        Set<ListNode> s1 = new HashSet<>();
        while (headA != null){
            s1.add(headA);
            headA = headA.next;
        }
        while (headB != null){
            if (s1.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
