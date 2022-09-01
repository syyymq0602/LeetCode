package offer.GuangLianDa;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class l1 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()){
            int n = cin.nextInt();
            int[] fs = new int[n];
            int[] js = new int[n];
            for (int i = 0; i < n; i++) {
                fs[i] = cin.nextInt();
            }
            for (int i = 0; i < n; i++) {
                js[i] = cin.nextInt();
            }
            if(Arrays.equals(fs,js)){
                System.out.println(0);
                continue;
            }
            Set<Integer> set = new HashSet<>();
            int up = 0;
            int down = 0;
            int count = 0;
            while (up < n && down < n){
                if(set.contains(fs[up])){
                    up++;
                    continue;
                }
                if(fs[up] != js[down]){
                    set.add(js[down]);
                    down++;
                    count++;
                }else {
                    up++;
                    down++;
                }
            }
            System.out.println(count);
        }
    }
}
