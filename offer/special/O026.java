package offer.special;

import LL.scripts.ListNode;
import LL.scripts.ListNodeUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer II 026. 重排链表
 *
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 *
 * L0→ L1→ … → Ln-1→ Ln
 * 请将其重新排列后变为：
 * L0→Ln→L1→Ln-1→L2→Ln-2→ …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换
 *
 * 链表的长度范围为 [1, 5 * 10e4]
 * 1 <= node.val <= 1000
 */
public class O026 {
    public static void main(String[] args) {
        var node = ListNodeUtils.generateByArray(new int[]{1,2,3,4});
        reorderList(node);
    }

    private static void reorderList(ListNode head) {
        LinkedList<ListNode> deque = new LinkedList<>();
        while (head!=null){
            deque.offer(head);
            head = head.next;
        }
        head = deque.pollFirst();
        ListNode temp = head;
        boolean flag = true;
        while (!deque.isEmpty()){
            if(flag){
                ListNode t = deque.pollLast();
                t.next = null;
                temp.next = t;
            }else {
                ListNode t = deque.pollFirst();
                t.next = null;
                temp.next = t;
            }
            flag = !flag;
            temp = temp.next;
        }
    }
}
