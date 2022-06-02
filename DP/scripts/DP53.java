package DP.scripts;

/**
 * 53. 最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组:是数组中的一个连续部分。
 *
 * 1 <= nums.length <= 10e5
 * -10e4 <= nums[i] <= 10e4
 *
 * dp[i] = max{dp[i-1]+nums[i],nums[i]}
 */
public class DP53 {
    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,4,-6,6};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
