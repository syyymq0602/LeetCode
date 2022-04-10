package offer.scripts;

/**
 * 剑指 Offer 42. 连续子数组的最大和
 *
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)
 *
 * 1 <= arr.length <= 10^5
 * -100 <= arr[i] <= 100
 */
public class o42 {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    private static int maxSubArray(int[] nums) {
        int sumMax = nums[0];
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            pre = Math.max(nums[i],pre+nums[i]);
            sumMax = Math.max(sumMax,pre);
        }
        return sumMax;
    }
}
