package Array.script;

import java.util.Arrays;

/**
 * 1. 两数之和
 *
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target的那两个整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 */
public class AR1 {
    public static void main(String[] args) {
        var nums = new int[]{0,4,1,0};
        var target = 0;
        for (var item:twoSum(nums,target)) {
            System.out.println(item);
        }
    }

    private static int[] twoSum(int[] nums, int target) {
        int[] res = nums.clone();
        Arrays.sort(res);
        int left = 0;
        int right = nums.length-1;
        while (left<right){
            if(res[left]+res[right]==target){
                break;
            }else if(res[left]+res[right]<target){
                left++;
            }else if(res[left]+res[right]>target){
                right--;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == res[left]){
                left = i;
                break;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == res[right] && i!=left){
                right = i;
                break;
            }
        }
        return new int[]{left,right};
    }
}
