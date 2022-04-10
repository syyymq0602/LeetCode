package offer.special;

import java.util.Arrays;

/**
 * 剑指 Offer II 012. 左右两边子数组的和相等
 *
 * 给你一个整数数组nums ，请计算数组的 中心下标 。
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
 * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1
 *
 * 1 <= nums.length <= 10e4
 * -1000 <= nums[i] <= 1000
 */
public class O012 {
    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1,7,3,6,5,6}));
    }

    private static int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n+1];
        temp[0] = 0;
        for (int i = 0; i < n; i++) {
            temp[i+1] = temp[i] + nums[i];
        }
        for (int i = 1; i < n+1; i++) {
            if(temp[i-1] != temp[n] - temp[i]){
                continue;
            }
            return i-1;
        }
        return -1;
    }
}
