package offer.DIDi;

import java.util.Arrays;
import java.util.Scanner;

public class d1 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()){
            int n = cin.nextInt();
            int k = cin.nextInt();
            int[] nums = new int[n];
            double total = 0;
            for (int i = 0; i < n; i++) {
                nums[i] = cin.nextInt();
                total += nums[i];
            }
            double ave = total / n;
            Arrays.sort(nums);
            int index1 = n-1;
            int index2 = 0;
            double total2 = total;
            double ave2 = ave;
            while (index1 >= 0 && nums[index1] > k * ave){
                total -= nums[index1];
                --index1;
                ave = total / (index1 + 1);
            }
            while (index2 < n && nums[n-1] > k * ave2){
                total2 -= nums[index2];
                ++index2;
                ave2 = total2 / (n - index2);
            }
            int a = Math.max(index1 + 1,n - index2);
            System.out.println(a);
        }
    }
}
