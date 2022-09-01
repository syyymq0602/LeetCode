package offer.ZiJie;

import java.util.Scanner;

public class z2 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while(cin.hasNextLine()) {
            String nm = cin.nextLine();
            int n = Integer.parseInt(nm.split(" ")[0]);
            int m = Integer.parseInt(nm.split(" ")[1]);
            char[][] chars = new char[n][m];
            int row = 0;
            while (row < n){
                String line = cin.nextLine();
                for (int i = 0; i < m; i++) {
                    chars[row][i] = line.charAt(i);
                }
                row++;
            }

        }
    }
}
