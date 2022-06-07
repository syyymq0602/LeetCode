package DP.scripts;

/**
 * 152. 乘积最大子数组
 * <p>
 * 给你一个整数数组 nums，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * 测试用例的答案是一个32-位 整数。
 * 子数组 是数组的连续子序列
 * <p>
 * 1 <= nums.length <= 2 * 10e4
 * -10 <= nums[i] <= 10
 * nums 的任何前缀或后缀的乘积都 保证是一个 32 位 整数
 */
public class DP152 {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2,3,-2,4}));
    }

    private static int maxProduct(int[] nums) {
        int n = nums.length;
        int ans = nums[0], minF = nums[0], maxF = nums[0];
        for (int i = 1; i < n; i++) {
            int mF = maxF, mn = minF;
            maxF = Math.max(mF * nums[i], Math.max(mn * nums[i], nums[i]));
            minF = Math.min(mn * nums[i], Math.min(mF * nums[i], nums[i]));
            ans = Math.max(ans,maxF);
        }
        return ans;
    }
}
