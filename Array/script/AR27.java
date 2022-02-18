package Array.script;

import java.util.Arrays;

/**
 * 27. 移除元素
 *
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 50
 * 0 <= val <= 100
 */
public class AR27 {
    public static void main(String[] args) {
        var nums = new int[]{0,1,2,2,3,0,4,2};
        var val = 2;
        System.out.println(removeElement(nums,val));
        var res = "";
        for (int i = 0; i < removeElement(nums,val); i++) {
            res += nums[i] + " ";
        }
        System.out.println(res);
    }
    private static int removeElement(int[] nums, int val) {
        int n = nums.length;
        int right = 0;
        int left = 0;
        while (right<n){
            if(nums[right] != val){
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        return left;
    }
}
