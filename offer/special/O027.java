package offer.special;

import LL.scripts.ListNode;
import LL.scripts.ListNodeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 剑指 Offer II 027. 回文链表
 *
 * 给定一个链表的 头节点 head ，请判断其是否为回文链表。
 * 如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的
 *
 * 链表 L 的长度范围为 [1, 10e5]
 * 0 <= node.val <= 9
 */
public class O027 {
    public static void main(String[] args) {
        var node = ListNodeUtils.generateByArray(new int[]{1,2,3,2,1});
        System.out.println(isPalindrome(node));
    }

    private static boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head!=null){
            list.add(head.val);
            head = head.next;
        }
        int left = 0,right = list.size()-1;
        while (left <= right){
            if(!Objects.equals(list.get(left), list.get(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
