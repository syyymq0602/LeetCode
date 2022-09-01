package Array.script;

import java.util.Arrays;

/**
 * 1464. 数组中两元素的最大乘积
 *
 * 给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，使 (nums[i]-1)*(nums[j]-1) 取得最大值。
 * 请你计算并返回该式的最大值
 *
 * 2 <= nums.length <= 500
 * 1 <= nums[i] <= 10^3
 */
public class AR1464 {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{3,4,5,2}));
    }

    private static int maxProduct(int[] nums) {
        int a = nums[0], b = nums[1];
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > a) {
                b = a;
                a = nums[i];
            } else if (nums[i] > b) {
                b = nums[i];
            }
        }
        return (a - 1) * (b - 1);
    }
}
