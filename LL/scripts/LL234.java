package LL.scripts;

import java.util.ArrayList;
import java.util.List;

/**
 * 234. 回文链表
 *
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 *
 * 链表中节点数目在范围[1, 10e5] 内
 * 0 <= Node.val <= 9
 */
public class LL234 {
    public static void main(String[] args) {
        var node  = ListNodeUtils.generateByArray(new int[]{1,2,2,1});
        System.out.println(isPalindrome(node));
    }

    private static boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head!=null){
            list.add(head.val);
            head = head.next;
        }
        int start = 0, end = list.size()-1;
        while (start <= end){
            if(list.get(start) != list.get(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
