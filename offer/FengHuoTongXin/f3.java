package offer.FengHuoTongXin;

import java.util.PriorityQueue;
import java.util.Scanner;

public class f3 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()){
            int n = cin.nextInt();
            int q = cin.nextInt();
            int[] me = new int[n];
            int[] other = new int[n];
            for (int i = 0; i < n; i++) {
                me[i] = cin.nextInt();
            }
            for (int i = 0; i < n; i++) {
                other[i] = cin.nextInt();
            }
            while (q-- > 0){
                int meBL = cin.nextInt();
                int otherBL = cin.nextInt();
                PriorityQueue<Integer> meMax = new PriorityQueue<>(n,(a,b) -> b - a);
                PriorityQueue<Integer> otherMin = new PriorityQueue<>(n,(a,b) -> a - b);
                for (int item:me){
                    meMax.offer(item);
                }
                for (int item:other){
                    otherMin.offer(item);
                }
                int sum = 0;
                while (!meMax.isEmpty() && !otherMin.isEmpty()){
                    if(meMax.peek() * meBL <= otherMin.peek() * otherBL){
                        break;
                    }
                    int diff = meMax.poll() * meBL - otherMin.poll() * otherBL;
                    sum += diff;
                }
                System.out.println(sum);
            }
        }
    }
}



