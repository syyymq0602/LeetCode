package offer.FengHuoTongXin;

import java.util.Scanner;

public class f1 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()){
            int a = cin.nextInt();
            int b = cin.nextInt();
            int c = cin.nextInt();
            int sum = a + b;
            int maxNum = sum / c;
            int minAns = Integer.MAX_VALUE;
            int minNum = Math.min(a,b);
            int start = Math.max(minNum - maxNum / 2, 0);
            int end = sum / 2;
            while (start <= end){
                if(start / c + (sum - start) / c != maxNum){
                    start++;
                    continue;
                }
                minAns = Math.min(minAns, Math.abs(start - Math.min(a,b)) + Math.abs((sum - start)-Math.max(a,b)));
                start++;
            }
            System.out.println(minAns);
        }
    }
}

