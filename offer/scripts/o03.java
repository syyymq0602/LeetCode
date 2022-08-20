package offer.scripts;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 03. 数组中重复的数字
 *
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
 * 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 2 <= n <= 100000
 */
public class o03 {
    public static void main(String[] args) {
        System.out.println(findRepeatNumber1(new int[]{2, 3, 1, 0, 2, 5, 3}));
        System.out.println(Integer.parseInt(new StringBuilder("053").toString()));
    }

    private static int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == nums[i+1]){
                return nums[i];
            }
        }
        return -1;
    }

    private static int findRepeatNumber1(int[] nums){
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(!set.add(nums[i])){
                return nums[i];
            }
        }
        return -1;
    }
}
