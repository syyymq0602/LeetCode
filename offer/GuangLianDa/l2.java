package offer.GuangLianDa;

import java.util.Scanner;

public class l2 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()){
            int n = cin.nextInt();
            int m = cin.nextInt();
            int[][] rules = new int[m][3];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < 3; j++) {
                    rules[i][j] = cin.nextInt();
                }
            }
            // 第三列转换为最少的空位数
            int sunTotal = 0;
            for (int i = 0; i < m; i++) {
                rules[i][2] = rules[i][1] - rules[i][0] + 1 - rules[i][2];
                sunTotal += rules[i][2];
            }
            for (int i = 1; i < m; i++) {
                int sun = 0;
                if(rules[i][0] > rules[i-1][1]){
                    sun = 0;
                }else if(rules[i-1][0] < rules[i][0]) {
                    int diff = rules[i-1][1] - rules[i][0] + 1;
                    int k1 = rules[i-1][2];
                    int k2 = rules[i][2];
                    int kmax = Math.max(k1,k2);
                    sun = Math.min(diff, kmax);
                }else {
                    sun = Math.min(rules[i-1][2],rules[i][2]);
                }
                sunTotal -= sun;
            }
            System.out.println(n-sunTotal);
        }
    }
}
