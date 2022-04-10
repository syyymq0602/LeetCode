package offer.scripts;

import LL.scripts.ListNode;

import static LL.scripts.ListNodeUtils.generateByArray;

/**
 * 剑指 Offer 18. 删除链表的节点
 *
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点
 *
 * 题目保证链表中节点的值互不相同
 * 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
 */
public class o18 {
    public static void main(String[] args) {
        var node = generateByArray(new int[]{4,5,1,9});
        ListNode node1 = deleteNode(node, 5);
        System.out.println();
    }

    private static ListNode deleteNode(ListNode head, int val) {
        ListNode root = new ListNode(-1);
        root.next = head;
        if(head.val == val){
            return root.next.next;
        }
        ListNode left = head;
        ListNode right = head.next;
        while (right != null){
            if(right.val == val){
                left.next = right.next;
                break;
            }
            right = right.next;
            left = left.next;
        }
        return root.next;
    }
}
