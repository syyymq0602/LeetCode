package offer.JingDong;

import java.util.Scanner;

public class j4 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()) {
            int n = cin.nextInt();
            int[] all = new int[n];
            int max = 0;
            for (int i = 0; i < n; i++) {
                all[i] = cin.nextInt();
                if(all[i] > max){
                    max = all[i];
                }
            }
            int count = 0;
            for (int i = 0; i < n; i++) {
                if(all[i] < max){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
