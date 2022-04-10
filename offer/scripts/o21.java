package offer.scripts;

import java.util.Arrays;

/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 *
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分
 *
 * 0 <= nums.length <= 50000
 * 0 <= nums[i] <= 10000
 */
public class o21 {
    public static void main(String[] args) {
        var l1 = new int[]{1,2,3,4};
        System.out.println(Arrays.toString(exchange(l1)));
    }

    private static int[] exchange(int[] nums) {
        if(nums.length == 0){
            return nums;
        }
        int left = 0,right = nums.length-1;
        while (left<right){
            if(nums[left]%2 ==1 && nums[right]%2 == 1){
                left++;
            }else if(nums[left] % 2 == 0 && nums[right]%2 == 1){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }else if(nums[left]%2 ==1 && nums[right]%2 == 0){
                left++;
                right--;
            }else {
                right--;
            }
        }
        return nums;
    }
}
