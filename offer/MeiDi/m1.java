package offer.MeiDi;

public class m1 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new double[]{1.0,5.0,2.0}));
    }

    public static double maxProfit (double[] prices) {
        // write code here
        int len = prices.length;
        double min = Integer.MAX_VALUE;
        double ans = 0;
        for (int i = 0; i < len; i++) {
            if(min > prices[i]){
                min = prices[i];
            } else if (prices[i] - min > ans) {
                ans = prices[i] - min;
            }
        }
        return ans;
    }
}
