package DP.scripts;

/**
 * 416. 分割等和子集
 *
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 */
public class DP416 {
    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{9,5}));
    }

    private static boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if(sum % 2 != 0 || n < 2){
            return false;
        }
        int target = sum / 2;
        if(maxNum > target){
            return false;
        }
        boolean[][] dp = new boolean[n][target+1];
        // 如果不选取任何正整数，则被选取的正整数等于0
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        // 当i==0时，只有一个正整数nums[0]可以被选取
        dp[0][nums[0]] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                if(j < nums[i]){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }
            }
        }
        return dp[n-1][target];
    }
}

