package Array.script;

import java.util.Arrays;

/**
 * 581. 最短无序连续子数组
 *
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 *
 * 1 <= nums.length <= 10e4
 * -10e5 <= nums[i] <= 10e5
 */
public class AR581 {
    public static void main(String[] args) {
        System.out.println(findUnsortedSubarray(new int[]{1,2,3,3,3}));
    }

    private static int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] copy = new int[n];
        copy = Arrays.copyOf(nums,n);
        Arrays.sort(copy);
        int total = 0;
        int left = 0;
        int right = n-1;
        while (left < n){
            if(nums[left] != copy[left]){
                break;
            }
            ++total;
            ++left;
        }
        while (right > left){
            if(nums[right] != copy[right]){
                break;
            }
            ++total;
            --right;
        }
        return n - total;
    }
}
