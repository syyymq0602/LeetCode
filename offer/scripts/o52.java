package offer.scripts;

import LL.scripts.ListNode;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

import static LL.scripts.ListNodeUtils.generateByArray;

/**
 * 剑指 Offer 52. 两个链表的第一个公共节点
 *
 * 输入两个链表，找出它们的第一个公共节点。
 *
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 * 本题与主站 160 题相同：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 *
 */
public class o52 {
    public static void main(String[] args) {
        var l1 = generateByArray(new int[]{4});
        var l2 = generateByArray(new int[]{5,0,2});
        var l3 = generateByArray(new int[]{1,8,4,5});
        l1.next = l3;
        l2.next.next.next = l3;
        var ans = getIntersectionNode(l1,l2);
        System.out.println();
    }

    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null){
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null){
            if(set.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
