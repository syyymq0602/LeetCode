package offer.Meituan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class m3 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while(cin.hasNextInt()) {
            int n = cin.nextInt();
            int[] zm = new int[n];
            int[] fm = new int[n];
            Map<Integer,Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                zm[i] = cin.nextInt();
                map.put(zm[i], map.getOrDefault(zm[i],0)+1);
            }
            for (int i = 0; i < n; i++) {
                fm[i] = cin.nextInt();
            }
            int maxNum;
            int maxCount = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if(entry.getValue() >= n / 2 + n %2){
                    System.out.println(0);
                    continue;
                }
                if(entry.getValue() > maxCount){
                    maxCount = entry.getValue();
                    maxNum = entry.getKey();
                }
            }
            System.out.println(0);
        }
    }
}
