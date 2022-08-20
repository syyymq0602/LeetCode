package DP.scripts;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 343. 整数拆分
 * <p>
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 * 返回 你可以获得的最大乘积 。
 * <p>
 * 2 <= n <= 58
 */
public class DP343 {
    public static void main(String[] args) throws IOException {
        System.out.println(integerBreak(10));
    }

    private static int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(Math.max(j * (i - j), j * dp[i - j]),dp[i]);
            }
        }
        return dp[n];
    }
}
