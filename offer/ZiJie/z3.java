package offer.ZiJie;

import java.util.List;
import java.util.Scanner;

public class z3 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while(cin.hasNextLine()) {
            String nStr = cin.nextLine();
            String cy = cin.nextLine();
            StringBuilder builder = new StringBuilder();
            boolean flag = false;
            for (int i = 0; i < cy.length(); i++) {
                if(cy.charAt(i) == '{'){
                    flag = true;
                    continue;
                } else if (cy.charAt(i) == '}') {
                    flag = false;
                    builder.append('*');
                    continue;
                }
                if(!flag){
                    builder.append(cy.charAt(i));
                }
            }
            String deal = builder.toString();
            int y = deal.length();
            int n = Integer.parseInt(nStr);
            while (n-- > 0){
                String title = cin.nextLine();
                int x = title.length();
                // 前x  前y
                boolean[][] dp = new boolean[x+1][y+1];
                dp[0][0] = true;
                for (int i = 1; i <= y; i++) {
                    if(deal.charAt(i-1) == '*'){
                        dp[0][i] = true;
                    }else {
                        break;
                    }
                }
                for (int i = 1; i <= x; i++) {
                    for (int j = 1; j <= y; j++) {
                        if(deal.charAt(j-1) == '*'){
                            dp[i][j] = dp[i-1][j] || dp[i][j-1];
                        }else if(deal.charAt(j-1) == title.charAt(i-1)){
                            dp[i][j] = dp[i-1][j-1];
                        }
                    }
                }
                if(dp[x][y]){
                    System.out.println("True");
                }else {
                    System.out.println("False");
                }
            }
        }
    }
}
