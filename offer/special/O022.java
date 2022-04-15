package offer.special;

import LL.scripts.ListNode;
import LL.scripts.ListNodeUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 剑指 Offer II 022. 链表中环的入口节点
 *
 * 给定一个链表，返回链表开始入环的第一个节点。 从链表的头节点开始沿着 next 指针进入环的第一个节点为环的入口节点。如果链表无环，则返回null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环.
 * 注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 *
 * 链表中节点的数目范围在范围 [0, 10e4] 内
 * -10e5 <= Node.val <= 10e5
 * pos 的值为 -1 或者链表中的一个有效索引
 */
public class O022 {
    public static void main(String[] args) {
        var node = ListNodeUtils.generateByArray(new int[]{3,2,0,-4});
        var ans = detectCycle(node);
    }

    private static ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        while (head != null){
            if(!set.add(head)){
                return head;
            }
            head = head.next;
        }
        return null;
    }
}
