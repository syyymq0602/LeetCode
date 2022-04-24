package offer.special;

/**
 * 剑指 Offer II 009. 乘积小于 K 的子数组
 *
 * 给定一个正整数数组 nums和整数 k ，请找出该数组内乘积小于 k 的连续的子数组的个数
 *
 * 1 <= nums.length <= 3 * 10e4
 * 1 <= nums[i] <= 1000
 * 0 <= k <= 10e6
 */
public class O009 {
    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[]{10,5,2,6},100));
    }

    private static int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        if(k <= 1) return 0;
        int ans = 0;
        int start = 0, end = 0;
        int mul = 1;
        while(end < n){
            mul *= nums[end];
            while(mul >= k){
                mul /= nums[start];
                start++;
            }
            ans += end - start + 1;
            end++;
        }
        return ans;
    }
}
