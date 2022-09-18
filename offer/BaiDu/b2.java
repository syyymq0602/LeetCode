package offer.BaiDu;

import java.util.Scanner;

public class b2 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextLong()){
            int n = cin.nextInt();
            long[] sh = new long[n];
            long sumMp = 0;
            for (int i = 0; i < n; i++) {
                sh[i] = cin.nextLong();
            }
            int index = 0;
            while (index < n){
                while (judge(sh,index)){
                    sh[index] -= 1;
                    sh[index+1] -= 2;
                    sh[index+2] -= 3;
                    sumMp += 5;
                }
                sumMp += sh[index];
                sh[index] = 0;
                index++;
            }
            System.out.println(sumMp);
        }
    }

    private static boolean judge(long[] nums,int startIndex){
        int len = nums.length;
        // 超界
        if(startIndex + 2 >= len){
            return false;
        }
        if(nums[startIndex] >= 1 && nums[startIndex+1] >=2 && nums[startIndex+2] >= 3){
            return true;
        }
        return false;
    }
}
