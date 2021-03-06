package DP.scripts;

/**
 * 213. 打家劫舍 II
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，
 * 这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 */
public class DP213 {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{2,3,2}));
    }

    private static int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        if(n == 2){
            return Math.max(nums[0],nums[1]);
        }
        return Math.max(rob(nums,0,n-1),rob(nums,1,n));
    }

    private static int rob(int[] nums,int start,int end) {
        int[] dp = new int[end-start];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start+1]);
        for (int i = start+2; i < end; i++) {
            dp[i-start] = Math.max(dp[i-start-1],dp[i-start-2]+nums[i]);
        }
        return dp[end-start-1];
    }
}
