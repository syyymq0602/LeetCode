package DP.scripts;

/**
 * 96. 不同的二叉搜索树
 *
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 *
 * 1 <= n <= 19
 *
 * 卡特兰数
 *
 * G(n) = G(0)*G(n-1)+G(1)*G(n-2)+...+G(n-1)*(0)
 */
public class DP96 {
    public static void main(String[] args) {
        var n = 8;
        System.out.println(numTrees(n));
    }

    private static int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n+1; i++) {
            for (int j = 1; j < i+1; j++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
}
