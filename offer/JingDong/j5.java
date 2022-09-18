package offer.JingDong;

import java.util.Scanner;

public class j5 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()) {
            int n = cin.nextInt();
            int[] nums = new int[n];
            int maxNum = 0;
            for (int i = 0; i < n; i++) {
                nums[i] = cin.nextInt();
                if(nums[i] > maxNum){
                    maxNum = nums[i];
                }
            }
            int[] dp = new int[maxNum+1];
            dp[1] = 0;
            dp[2] = 1;
            for (int i = 3; i <= maxNum; i++) {
                int min = Integer.MAX_VALUE;
                int t = (int)Math.sqrt(i);
                for (int j = 2; j <= t; j++) {
                    if(i % j != 0){
                        continue;
                    }
                    int o = i / j;
                    min = Math.min(min,dp[j] + dp[o] + 1);
                }
                dp[i] = Math.min(dp[i-1]+1, min);
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                ans += dp[nums[i]];
            }
            System.out.println(ans);
        }
    }
}
