package offer.XieCheng;

import java.util.Scanner;

public class x4 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()){
            int n = cin.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = cin.nextInt();
            }
            if(n == 2){
                System.out.println(0);
                continue;
            }
            int[] newNums = new int[n+2];
            newNums[0] = nums[1];
            newNums[newNums.length-1] = nums[n-2];
            for (int i = 1; i <= n; i++) {
                newNums[i] = nums[i-1];
            }
            int maxIndex = 1;
            int maxDiff = Math.abs(nums[1] - nums[0]);
            for (int i = 1; i <= n; i++) {
                int diff = Math.abs(newNums[i+1] - newNums[i]);
                if(diff > maxDiff){
                    maxDiff = diff;
                    maxIndex = i;
                }
            }
            int maxAns1 = 0;
            int temp = newNums[maxIndex];
            newNums[maxIndex] = getAve(newNums,maxIndex);
            for (int i = 1; i <= n; i++) {
                if(Math.abs(newNums[i+1] - newNums[i]) > maxAns1){
                    maxAns1 = Math.abs(newNums[i+1] - newNums[i]);
                }
            }
            newNums[maxIndex] = temp;
            int maxAns2 = 0;
            newNums[maxIndex+1] = getAve(newNums,maxIndex+1);
            for (int i = 1; i <= n; i++) {
                if(Math.abs(newNums[i+1] - newNums[i]) > maxAns2){
                    maxAns2 = Math.abs(newNums[i+1] - newNums[i]);
                }
            }
            System.out.println(Math.min(maxAns1,maxAns2));
        }
    }

    private static int getAve(int[] nums,int index){
        int num = nums[index+1] + nums[index-1];
        return num / 2;
    }
}
