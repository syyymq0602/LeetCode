package LL.scripts;

import static LL.scripts.LL2.generateByArray;

/**
 * 83. 删除排序链表中的重复元素
 * <p>
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 * <p>
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 */
public class LL83 {

    public static void main(String[] args) {
        var head = generateByArray(new int[]{1, 1,1, 2, 3, 3,3});
        var res = deleteDuplicates(head);
        System.out.println();
    }

    private static ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        ListNode ans = cur;
        while ( cur.next !=null) {
            if(cur.next.val == cur.val){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return ans;
    }
}
