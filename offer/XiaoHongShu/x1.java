package offer.XiaoHongShu;

import java.util.PriorityQueue;
import java.util.Scanner;

public class x1 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()){
            int n = cin.nextInt();
            int m = cin.nextInt();
            int id = cin.nextInt();
            int[][] zyx = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    zyx[i][j] = cin.nextInt();
                }
            }
            PriorityQueue<int[]> queue = new PriorityQueue<>(n,(a,b)->{
               if(a[1] != b[1]){
                   return b[1] - a[1];
               } else {
                   return a[0] - b[0];
               }
            });
            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = 0; j < m; j++) {
                    sum += zyx[i][j];
                }
                int[] temp = new int[]{i,sum};
                queue.offer(temp);
            }
            int count = 0;
            while (!queue.isEmpty()){
                int tempId = queue.poll()[0];
                count++;
                if(tempId + 1 == id){
                    break;
                }
            }
            System.out.println(count);
        }
    }
}
