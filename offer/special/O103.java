package offer.special;

import java.util.Arrays;

/**
 * 剑指 Offer II 103. 最少的硬币数目
 *
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回-1。
 * 你可以认为每种硬币的数量是无限的
 *
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 2e31 - 1
 * 0 <= amount <= 10e4
 */
public class O103 {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{2},3));
    }

    private static int coinChange(int[] coins, int amount) {
        int n = coins.length;
        // dp[x]指凑成总金额为x硬币的最小个数
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
