package offer.special;

import LL.scripts.ListNode;
import LL.scripts.ListNodeUtils;

import java.util.Stack;

/**
 * 剑指 Offer II 025. 链表中的两数相加
 *
 * 给定两个 非空链表 l1和 l2来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 可以假设除了数字 0 之外，这两个数字都不会以零开头
 *
 * 链表的长度范围为 [1, 100]
 * 0 <= node.val <= 9
 * 输入数据保证链表代表的数字无前导 0
 */
public class O025 {
    public static void main(String[] args) {
        var l1 = ListNodeUtils.generateByArray(new int[]{5});
        var l2 = ListNodeUtils.generateByArray(new int[]{5});
        var ans = addTwoNumbers(l1,l2);
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        ListNode t1 = l1;
        ListNode t2 = l2;
        while (t1!=null){
            s1.push(t1.val);
            t1 = t1.next;
        }
        while (t2!=null){
            s2.push(t2.val);
            t2 = t2.next;
        }
        int index = 0;
        ListNode pre = null;
        while (!s1.isEmpty() || !s2.isEmpty()){
            int num1 = s1.isEmpty()?0:s1.pop();
            int num2 = s2.isEmpty()?0:s2.pop();
            int sum = num1 + num2 + index;
            if(sum >= 10){
                index = sum / 10;
                sum = sum % 10;
            }else {
                index = 0;
            }
            ListNode cur = new ListNode(sum);
            cur.next = pre;
            pre = cur;
        }
        if(index == 1){
            pre = new ListNode(1,pre);
        }
        return pre;
    }
}
