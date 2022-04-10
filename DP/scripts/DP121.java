package DP.scripts;

/**
 * 121. 买卖股票的最佳时机
 *
 * 给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 */
public class DP121 {
    public static void main(String[] args) {
        var prices = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {
        int minPro = Integer.MAX_VALUE;
        int maxPro = 0;
        for (int i = 0; i < prices.length ; i++) {
            if(prices[i]<minPro){
                minPro = prices[i];
            }else if(prices[i]-minPro>maxPro){
                maxPro = prices[i]-minPro;
            }
        }
        return maxPro;
    }
}
