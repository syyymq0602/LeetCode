package DP.scripts;

/**
 * 312. 戳气球
 * <p>
 * 有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组nums中。
 * 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。
 * 这里的 i - 1 和 i + 1 代表和i相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。
 * 求所能获得硬币的最大数量
 * <p>
 * n == nums.length
 * 1 <= n <= 300
 * 0 <= nums[i] <= 100
 * <p>
 * dp[i][j] 表示开区间 (i,j) 内你能拿到的最多金币
 * dp[i][j] = dp[i][k] + max(val[i]*val[k]*val[j]) + dp[k][j];
 */
public class DP312 {
    public static void main(String[] args) {
        System.out.println(maxCoins(new int[]{3, 1, 5, 8}));
    }

    private static int maxCoins(int[] nums) {
        int n = nums.length;
        // 创建一个辅助数组，并在首尾各添加1，方便处理边界情况
        int[] temp = new int[n + 2];
        temp[0] = 1;
        temp[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            temp[i + 1] = nums[i];
        }
        int[][] dp = new int[n + 2][n + 2];
        // len表示开区间长度
        for (int len = 3; len <= n + 2; len++) {
            // i表示开区间左端点
            for (int i = 0; i <= n + 2 - len; i++) {
                int res = 0;
                // k为开区间内的索引
                for (int k = i + 1; k < i + len - 1; k++) {
                    int left = dp[i][k];
                    int right = dp[k][i + len - 1];
                    res = Math.max(res, left + temp[i] * temp[k] * temp[i + len - 1] + right);
                }
                dp[i][i + len - 1] = res;
            }
        }
        return dp[0][n + 1];
    }
}
