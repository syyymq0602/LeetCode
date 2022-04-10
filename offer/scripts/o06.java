package offer.scripts;



import LL.scripts.ListNode;

import java.util.LinkedList;

import static LL.scripts.ListNodeUtils.generateByArray;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 *
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * 0 <= 链表长度 <= 10000
 */
public class o06 {
    public static void main(String[] args) {
        var nums = new int[]{1,3,2};
        var node = generateByArray(nums);
        var res = reversePrint(node);
        for (var item:res) {
            System.out.print(item + " ");
        }
    }

    private static int[] reversePrint(ListNode head) {
        if(head == null){
            return new int[]{};
        }
        LinkedList<Integer> stack = new LinkedList<>();
        while (head != null){
            stack.push(head.val);
            head = head.next;
        }
        int size = stack.size();
        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            ans[i]  = stack.pop();
        }
        return ans;
    }
}
