package NK;

import java.util.Arrays;
import java.util.Scanner;

public class NK2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] r1 = new int[4];
        while(sc.hasNext()){
            for (int i = 0; i < r1.length; i++) {
                r1[i] = sc.nextInt();
            }
            int[] r2 = new int[r1[1]];
            for (int i = 0; i < r2.length; i++) {
                r2[i] = sc.nextInt();
            }
            Arrays.sort(r2);
            int min = Math.min(r1[2], r1[3]);
            int max = Math.max(r1[2], r1[3]);
            if(min>r2[0] || max<r2[r1[1]-1]){
                System.out.println("NO");
            }else if(min==r2[0] && max==r2[r1[1]-1]){
                System.out.println("YES");
            }else if(min==r2[0] && r1[0]-r1[1]>=1){
                System.out.println("YES");
            }else if(max==r2[r1[1]-1] && r1[0]-r1[1]>=1){
                System.out.println("YES");
            }else if(r1[0]-r1[1]>=2){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
        sc.close();
    }
}
