package offer.XiaoHongShu;

import java.util.Arrays;
import java.util.Scanner;

public class x2 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()){
            int n = cin.nextInt();
            long K = cin.nextLong();
            int[] weiLi = new int[n];
            for (int i = 0; i < n; i++) {
                weiLi[i] = cin.nextInt();
            }
            Arrays.sort(weiLi);
            int count = 0;
            for (int i = weiLi.length - 1; i >= 0 ; i--) {
                for (int j = i-1; j >= 0 ; j--) {
                    if(weiLi[i] * (long)weiLi[j] >= K){
                        count++;
                    }else {
                        break;
                    }
                }
            }
            System.out.println(count * 2);
        }
    }
}
