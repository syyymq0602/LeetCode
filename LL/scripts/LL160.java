package LL.scripts;

import java.util.HashSet;
import java.util.Set;

/**
 * 160. 相交链表
 *
 * 给你两个单链表的头节点headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * 图示两个链表在节点 c1 开始相交：
 * 题目数据 保证 整个链式结构中不存在环。
 * 注意，函数返回结果后，链表必须 保持其原始结构
 *
 * listA 中节点数目为 m
 * listB 中节点数目为 n
 * 1 <= m, n <= 3 * 10e4
 * 1 <= Node.val <= 10e5
 * 0 <= skipA <= m
 * 0 <= skipB <= n
 * 如果 listA 和 listB 没有交点，intersectVal 为 0
 * 如果 listA 和 listB 有交点，intersectVal == listA[skipA] == listB[skipB
 */
public class LL160 {
    public static void main(String[] args) {

    }

    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode ans = null;
        while (headA != null){
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null){
            if(set.contains(headB)){
                ans = headB;
                break;
            }
            headB = headB.next;
        }
        return ans;
    }
}
