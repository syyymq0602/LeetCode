package offer.XieCheng;

import java.util.Scanner;

public class x2 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()){
            int n = cin.nextInt();
            while (n -- > 0){
                int a = cin.nextInt();
                int b = cin.nextInt();
                int c = cin.nextInt();
                int min1 = Math.min(a,c);
                int count = 0;
                if(b <= min1){
                    count = b * 2;
                }else {
                    int diff = b - min1;
                    count = min1 * 2 + diff - 1;
                }
                System.out.println(count);
            }
        }
    }
}
