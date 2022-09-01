package offer.ZhongXing;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class z1 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while(cin.hasNextInt()) {
            int n = cin.nextInt();
            int ys = cin.nextInt();
            int[] prices = new int[n];
            for (int i = 0; i < prices.length; i++) {
                prices[i] = cin.nextInt();
            }
            int[] ans = new int[]{-1,-1};
            Set<Integer> set = new HashSet<>();
            set.add(prices[0]);
            for (int i = 1; i < n; i++) {
                if(set.contains(ys - prices[i])){
                    ans[0] = ys - prices[i];
                    ans[1] = prices[i];
                    break;
                }else {
                    set.add(prices[i]);
                }
            }
            if(ans[0] == -1){
                System.out.println("Not Found");
            }else {
                System.out.println(ans[0] + " " + ans[1]);
            }
        }
    }
}
