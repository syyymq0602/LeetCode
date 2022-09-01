package offer.TuHu;

import java.util.Arrays;
import java.util.Scanner;

public class t2 {
    public static void main(String[] args) {
        System.out.println(change(new int[]{1,2,5},11));
    }

    public static int change (int[] oils, int box) {
        // write code here
        int len = oils.length;
        int[] dp = new int[box+1];
        Arrays.fill(dp,box+1);
        dp[0] = 0;
        for(int i = 1;i<= box;i++){
            for(int j = 0;j < len;j++){
                if(i - oils[j] >= 0){
                    dp[i] = Math.min(dp[i],dp[i-oils[j]]+1);
                }
            }
        }
        return dp[box] > box ? -1:dp[box];
    }
}
