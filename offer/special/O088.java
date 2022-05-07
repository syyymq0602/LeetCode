package offer.special;

import java.util.Arrays;

/**
 * 剑指 Offer II 088. 爬楼梯的最少成本
 *
 * 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值cost[i]（下标从 0 开始）。
 * 每当爬上一个阶梯都要花费对应的体力值，一旦支付了相应的体力值，就可以选择向上爬一个阶梯或者爬两个阶梯。
 * 请找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯
 *
 * 2 <= cost.length <= 1000
 * 0 <= cost[i] <= 999
 */
public class O088 {
    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }

    private static int minCostClimbingStairs(int[] cost) {
        for (int i = 2; i < cost.length; i++) {
            cost[i] = Math.min(cost[i-1], cost[i-2]) + cost[i];
        }
        return Math.min(cost[cost.length-2], cost[cost.length-1]);
    }
}
