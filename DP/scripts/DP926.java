package DP.scripts;

/**
 * 926. 将字符串翻转到单调递增
 *
 * 如果一个二进制字符串，是以一些 0（可能没有 0）后面跟着一些 1（也可能没有 1）的形式组成的，那么该字符串是 单调递增 的。
 * 给你一个二进制字符串 s，你可以将任何 0 翻转为 1 或者将 1 翻转为 0 。
 * 返回使 s 单调递增的最小翻转次数。
 *
 * 1 <= s.length <= 10e5
 * s[i] 为 '0' 或 '1'
 */
public class DP926 {
    public static void main(String[] args) {
        System.out.println(minFlipsMonoIncr("00110"));
    }

    private static int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[][] dp = new int[n][2];
        dp[0][0] = s.charAt(0) == '0' ? 0 : 1;
        dp[0][1] = s.charAt(0) == '1' ? 0 : 1;
        for (int i = 1; i < n; i++) {
            if(s.charAt(i) == '0'){
                dp[i][0] = dp[i-1][0];
                dp[i][1] = Math.min(dp[i-1][0],dp[i-1][1])+1;
            }else {
                dp[i][1] = Math.min(dp[i-1][0],dp[i-1][1]);
                dp[i][0] = dp[i-1][0] + 1;
            }
        }
        return Math.min(dp[n-1][0],dp[n-1][1]);
    }
}
