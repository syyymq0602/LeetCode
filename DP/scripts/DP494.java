package DP.scripts;

import java.util.ArrayList;
import java.util.List;

/**
 * 494. 目标和
 * <p>
 * 给你一个整数数组 nums 和一个整数 target 。
 * 向数组中的每个整数前添加'+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目
 * <p>
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 1000
 * 0 <= sum(nums[i]) <= 1000
 * -1000 <= target <= 1000
 */
public class DP494 {
    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 0,1));
    }

    private static int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (Math.abs(target) > sum) {
            return 0;
        }
        int t = 2 * sum + 1;
        int[][] dp = new int[n][t];
        if (nums[0] == 0) {
            dp[0][sum] = 2;
        } else {
            dp[0][sum - nums[0]] = 1;
            dp[0][sum + nums[0]] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < t; j++) {
                int left = (j - nums[i]) >= 0 ? j - nums[i] : 0;
                int right = (j + nums[i]) < t ? j + nums[i] : 0;
                dp[i][j] = dp[i - 1][left] + dp[i - 1][right];
            }
        }
        return dp[n - 1][sum + target];
    }

    private static int findTargetSumWays(int[] nums, int S,int pre) {
        int sum = 0;
        for (int num : nums){
            sum += num;
        }
        if (sum < S || (sum + S) % 2 == 1) {
            return 0;
        }
        int W = (sum + S) / 2;
        int[] dp = new int[W + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = W; i >= num; i--) {
                dp[i] = dp[i] + dp[i - num];
            }
        }
        return dp[W];
    }
}
