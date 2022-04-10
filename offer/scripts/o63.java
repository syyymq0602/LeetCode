package offer.scripts;

/**
 * 剑指 Offer 63. 股票的最大利润
 *
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 *
 * 0 <= 数组长度 <= 10^5
 */
public class o63 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }

    private static int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i] < min){
                min = prices[i];
            }
            if(prices[i] - min > max){
                max = prices[i] - min;
            }
        }
        return max;
    }
}
