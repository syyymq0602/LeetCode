package Array.script;

import java.util.Arrays;

/**
 * 1470. 重新排列数组
 *
 * 给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
 * 请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组
 *
 * 1 <= n <= 500
 * nums.length == 2n
 * 1 <= nums[i] <= 10^3
 */
public class AR1470 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(shuffle(new int[]{2,5,1,3,4,7},3)));
    }

    private static int[] shuffle(int[] nums, int n) {
        int len = nums.length;
        int[] ans = new int[len];
        int count = 0;
        for (int i = 0; i < len-1; i += 2) {
            ans[i] = nums[count];
            ans[i+1] = nums[count+n];
            count++;
        }
        return ans;
    }
}
