package offer.ManBang;

import java.util.Arrays;
import java.util.Scanner;

public class m2 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()){
            int n = cin.nextInt();
            int[] scores = new int[n];
            for (int i = 0; i < n; i++) {
                scores[i] = cin.nextInt();
            }
            Arrays.sort(scores);
            int index = 0;
            int count1 = 0;
            while (index < n - 2){
                // 二人都不行，只能一人
                if(scores[index+1] - scores[index] > 20){
                    index = index + 1;
                }
                // 至少可以两人
                else {
                    // 只能两人
                    if(scores[index + 2] - scores[index] > 10){
                        index = index + 2;
                    }
                    // 可以三人
                    else {
                        index = index + 3;
                    }
                }
                count1++;
            }
            if(index == n - 2){
                if(scores[index + 1] - scores[index] > 20){
                    count1 += 2;
                }else {
                    count1++;
                }
            } else if (index == n - 1) {
                count1++;
            }
            System.out.println(count1);
        }
    }
}
