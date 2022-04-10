package offer.scripts;

import java.util.Arrays;

/**
 * 剑指 Offer 57. 和为s的两个数字
 *
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^6
 */
public class o57 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15},9)));
    }

    private static int[] twoSum(int[] nums, int target) {
        if(nums.length < 2){
            return new int[]{};
        }
        int left = 0,right = nums.length-1;
        while (left<right){
            if(nums[left] + nums[right] > target){
                right--;
            }else if(nums[left] + nums[right] < target){
                left++;
            }else {
                return new int[]{nums[left],nums[right]};
            }
        }
        return new int[]{};
    }
}
