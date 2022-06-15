package DP.scripts;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 *
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回-1 。
 * 你可以认为每种硬币的数量是无限的
 *
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 2e31 - 1
 * 0 <= amount <= 10e4
 */
public class DP322 {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1,2,5},11));
    }

    private static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins){
                if(i >= coin){
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
