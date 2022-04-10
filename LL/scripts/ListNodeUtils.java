package LL.scripts;

public class ListNodeUtils {
    public static ListNode generateByArray(int[] nums) {
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        if (nums.length == 0) {
            return head.next;
        }
        int index = 0;
        while (index < nums.length){
            tail.next = new ListNode(nums[index]);
            tail = tail.next;
            index++;
        }
        return head.next;
    }
}
