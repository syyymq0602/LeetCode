package offer.DIDi;

import java.util.Scanner;

public class d2 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()){
            int n = cin.nextByte();
            int[] ans = new int[n];
            int[][] record = new int[3][n];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < n; j++) {
                    record[i][j] = cin.nextInt();
                }
            }
            for (int i = 0; i < n; i++) {
                int start = record[0][i];
                int end = record[1][i];
                int target = record[2][i];
                int count = 0;
                for (int j = start; j <= end; j++) {
                    if(b(j) == target){
                        ++ans[i];
                    }
                }
            }
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < n; i++) {
                builder.append(ans[i]).append(" ");
            }
            String out = builder.toString().trim();
            System.out.println(out);
        }
    }

    private static int b(int x){
        int ans = 0;
        while (x != 0){
            int geWei = x % 10;
            ans = ans ^ geWei;
            x = x / 10;
        }
        return ans;
    }
}
