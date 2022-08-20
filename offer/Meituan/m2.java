package offer.Meituan;

import java.util.Scanner;

public class m2 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while(cin.hasNextInt()) {
            int n = cin.nextInt();
            int[] nums = new int[n];
            int start = 0;
            for (int i = 0; i < n; i++) {
                nums[i] = cin.nextInt();
                if(nums[i] <= 0){
                    ++start;
                }
            }
            int total = start;
            int min = start;
            for (int i = 0; i < n; i++) {
                if(nums[i] == -1){
                    total--;
                }else if(nums[i] == 1){
                    total++;
                }
                min = Math.min(min,total);
            }
            System.out.println(min);
//            if(judge(nums,1) || judge(nums,-1)){
//                System.out.println(0);
//                continue;
//            }
//            int ans = Integer.MAX_VALUE;
//            int left,right;
//            for (int i = 0; i < n-1; i++) {
//                left = i;
//                right = i+1;
//                int temp = 0;
//                while (left >= 0){
//                    if(nums[left] >= 0){
//                        temp++;
//                    }
//                    left--;
//                }
//                while (right < n){
//                    if(nums[right] <= 0){
//                        temp++;
//                    }
//                    right++;
//                }
//                ans = Math.min(ans,temp);
//            }
//            System.out.println(ans);
        }
    }

    private static void m1(){

    }

    private static boolean judge(int[] nums, int m) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != m){
                return false;
            }
        }
        return true;
    }
}

//        Scanner cin = new Scanner(System.in);
//        while(cin.hasNextLine()) {
//            String line = cin.nextLine();
//            String[] s = line.split(" ");
//            int n = Integer.parseInt(s[0]);
//            int m = Integer.parseInt(s[1]);
//            int index = 0;
//
//        }
