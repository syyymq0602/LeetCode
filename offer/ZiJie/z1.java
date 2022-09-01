package offer.ZiJie;

import java.util.Scanner;

public class z1 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while(cin.hasNextLine()) {
            int t = Integer.parseInt(cin.nextLine());
            while (t-- > 0){
                String nk = cin.nextLine();
                int n = Integer.parseInt(nk.split(" ")[0]);
                int k = Integer.parseInt(nk.split(" ")[1]);
                String line = cin.nextLine();
                // 前n个 交换k次
                int[][] dp = new int[n][k+1];
                for (int i = 0; i <= k; i++) {
                    dp[0][i] = 0;
                }
                for (int i = 1; i < n; i++) {
                    dp[i][0] = dp[i-1][0] + Integer.parseInt(line.substring(i-1,i+1));
                }
                for (int i = 1; i < n; i++) {
                    for (int j = 1; j <= k; j++) {
                        StringBuilder b = new StringBuilder();
                        if(i == 1){
                            int pre = Integer.parseInt(line.substring(0,2));
                            dp[i][j] = dp[i-1][j] + pre;
                            int temp = dp[i-1][k-1] - pre + Integer.parseInt(b.append(line, 0, 2).reverse().toString());
                            dp[i][j] = Math.min(dp[i][j],temp);
                        }else {
                            String old = line.substring(i-2,i+1);
                            String newS = b.append(line.charAt(i-2)).
                                    append(line.charAt(i)).append(line.charAt(i-1)).toString();
                            int pre = Integer.parseInt(line.substring(i-1,i+1));
                            dp[i][j] = dp[i-1][j] + pre;
                            int temp = dp[i-1][k-1] - Integer.parseInt(old.substring(0,2))
                                    + Integer.parseInt(newS.substring(0,2)) + Integer.parseInt(newS.substring(1,3));
                            dp[i][j] = Math.min(dp[i][j],temp);
                        }
                    }
                }
                int min = Integer.MAX_VALUE;
                for (int i = 0; i <= k; i++) {
                    if(dp[n-1][i] < min){
                        min = dp[n-1][i];
                    }
                }
                System.out.println(min);
            }
        }
    }

    private static int getDiff(String line, int start, int end) {
        int pre = Integer.parseInt(line.substring(start,end));
        StringBuilder b = new StringBuilder();
        b.append(line.charAt(start)).append(line.charAt(start+2)).append(line.charAt(start+1));
        int swap = Integer.parseInt(b.toString());
        return swap - pre;
    }
}
