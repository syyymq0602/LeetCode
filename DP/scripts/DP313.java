package DP.scripts;

import java.util.Arrays;

/**
 * 313. 超级丑数
 *
 * 超级丑数 是一个正整数，并满足其所有质因数都出现在质数数组 primes 中。
 * 给你一个整数 n 和一个整数数组 primes ，返回第 n 个 超级丑数 。
 * 题目数据保证第 n 个 超级丑数 在 32-bit 带符号整数范围内。
 *
 * 1 <= n <= 10e5
 * 1 <= primes.length <= 100
 * 2 <= primes[i] <= 1000
 * 题目数据 保证 primes[i] 是一个质数
 * primes 中的所有值都 互不相同 ，且按 递增顺序 排列
 */
public class DP313 {
    public static void main(String[] args) {
        System.out.println(nthSuperUglyNumber(12,new int[]{2,7,13,19}));
    }

    private static int nthSuperUglyNumber(int n, int[] primes) {
        int pLen = primes.length;
        int[] indexes = new int[pLen];
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            // 因为选最小值，先假设一个最大值
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < pLen; j++) {
                dp[i] = Math.min(dp[i], dp[indexes[j]] * primes[j]);
            }

            // dp[i] 是之前的哪个丑数乘以对应的 primes[j] 选出来的，给它加 1
            for (int j = 0; j < pLen; j++) {
                if (dp[i] == dp[indexes[j]] * primes[j]) {
                    // 注意：这里不止执行一次，例如选出 14 的时候，2 和 7 对应的最小丑数下标都要加 1，大家可以打印 indexes 和 dp 的值加以验证
                    indexes[j]++;
                }
            }
        }
        return dp[n - 1];
    }
}
