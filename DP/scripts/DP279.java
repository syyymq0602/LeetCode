package DP.scripts;

import java.util.Arrays;

/**
 * 279. 完全平方数
 * <p>
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。
 * 例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是
 * <p>
 * 1 <= n <= 10e4
 */
public class DP279 {
    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }

    private static int numSquares(int n) {
        if (n == 0) return 0;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++){
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
