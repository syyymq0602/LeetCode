package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 找出整数数组中符合如下条件的所有元素：
 * 小于等于其前面的所有元素，大于等于后面所有元素
 * 示例：
 * 输入: [10 8 9 7 6 5 1 3 2]
 * 输出: [10 7 6 5]
 */
public class MT {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(find(new int[]{6,2,3,4,0,1,2,3,4,5})));
    }

    private static int[] find(int[] nums){
        int n = nums.length;
        if(n == 0){
            return new int[]{};
        }
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(check(nums,i,n)){
                temp.add(nums[i]);
            }
        }
        int[] ans = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            ans[i] = temp.get(i);
        }
        return ans;
    }

    private static boolean check(int[] nums, int i, int n) {
        int left = i-1,right = i + 1;
        int num = nums[i];
        while (left>=0){
            if(num > nums[left]){
                return false;
            }
            left--;
        }
        while (right<n){
            if(num < nums[right]){
                return false;
            }
            right++;
        }
        return true;
    }
}
