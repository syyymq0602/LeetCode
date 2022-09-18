package offer.ShuiDi;

import LL.scripts.ListNode;
import LL.scripts.ListNodeUtils;

public class s1 {
    public static void main(String[] args) {
        var node = ListNodeUtils.generateByArray(new int[]{1,2,4});
        System.out.println(findMidNode(node));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 查找单链表中间节点
     * @param head ListNode类 链表头节点
     * @return int整型
     */
    public static int findMidNode (ListNode head) {
        // write code here
        ListNode slow = head;
        ListNode fast = head;
        int total = 0;
        ListNode js = head;
        while (js != null){
            js = js.next;
            total++;
        }
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return total%2==0?slow.next.val:slow.val;
    }
}
