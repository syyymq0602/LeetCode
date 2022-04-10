package LL.scripts;

import static LL.scripts.ListNodeUtils.generateByArray;

/**
 * 203. 移除链表元素
 * <p>
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * <p>
 * 列表中的节点数目在范围 [0, 104] 内
 * 1 <= Node.val <= 50
 * 0 <= val <= 50
 */
public class LL203 {
    public static void main(String[] args) {
        var head = generateByArray(new int[]{1, 2, 6, 3, 4, 5, 6});
        var ans = removeElements(head, 6);
        System.out.println(ans);
    }

    private static ListNode removeElements(ListNode head, int val) {
        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode tail = first;
        while (tail.next != null) {
            if (tail.next.val == val) {
                tail.next = tail.next.next;
            }else {
                tail = tail.next;
            }
        }
        return first.next;
    }
}
