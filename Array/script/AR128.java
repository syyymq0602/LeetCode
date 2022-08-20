package Array.script;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 128. 最长连续序列
 *
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题
 *
 * 0 <= nums.length <= 10e5
 * -10e9 <= nums[i] <= 10e9
 */
public class AR128 {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100,4,200,1,3,2}));
    }

    private static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            set.add(num);
        }
        int ans = 0;
        for (int num:set){
            if(!set.contains(num - 1)){
                int size = 1;
                int pre = num;
                while (set.contains(pre+1)){
                    size++;
                    pre++;
                }
                ans = Math.max(ans,size);
            }
        }
        return ans;
    }
}
