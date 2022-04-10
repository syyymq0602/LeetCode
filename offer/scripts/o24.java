package offer.scripts;

import LL.scripts.ListNode;

import static LL.scripts.ListNodeUtils.generateByArray;


/**
 * 剑指 Offer 24. 反转链表
 *
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点
 *
 * 0 <= 节点个数 <= 5000
 */
public class o24 {
    public static void main(String[] args) {
        var node = generateByArray(new int[]{1,2,3,4,5});
        var res = reverseList(node);
        System.out.println();
    }

    private static ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null){
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }
}
