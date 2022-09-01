package Array.script;

import java.util.Arrays;
import java.util.Stack;

/**
 * 1475. 商品折扣后的最终价格
 *
 * 给你一个数组prices，其中prices[i]是商店里第i件商品的价格。
 * 商店里正在进行促销活动，如果你要买第i件商品，那么你可以得到与 prices[j] 相等的折扣，
 * 其中j是满足j > i且prices[j] <= prices[i]的最小下标，如果没有满足条件的j，你将没有任何折扣。
 * 请你返回一个数组，数组中第i个元素是折扣后你购买商品 i最终需要支付的价格。
 *
 * 1 <= prices.length <= 500
 * 1 <= prices[i] <= 10^3
 */
public class AR1475 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(finalPrices(new int[]{8,4,6,2,3})));
    }

    private static int[] finalPrices(int[] prices) {
        int n = prices.length;
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        while (index < n){
            while (!stack.isEmpty() && prices[index] <= prices[stack.peek()]){
                int index1 = stack.pop();
                prices[index1] -= prices[index];
            }
            stack.push(index);
            index++;
        }
        return prices;
    }
}
