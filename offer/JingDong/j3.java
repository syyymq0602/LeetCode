package offer.JingDong;

import java.util.Scanner;

public class j3 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()) {
            int n = cin.nextInt();
            if (n <= 6) {
                System.out.println(n / 6);
                continue;
            }
            int s = n - 6;
            long ans1 = (long) s * (s + 1) * (s + 2);
            long ans2 = (long) Math.pow(26,s);
            long ans = (ans1 * ans2) % (long) (Math.pow(10,9)+7);
            System.out.println((int)ans);
        }
    }
}
