package offer.Meituan;

import java.util.Scanner;

public class m1 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while(cin.hasNextInt()) {
            int T = cin.nextInt();
            while (T-- >0){
                int x = cin.nextInt();
                int y = cin.nextInt();
                int max = Math.max(x,y);
                int min = Math.min(x,y);
                if(max >= 2 * min){
                    System.out.println(min);
                }else {
                    System.out.println((max + min) /3);
                }
            }
        }
    }
}
