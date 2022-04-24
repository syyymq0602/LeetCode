package offer.special;


/**
 * 剑指 Offer II 008. 和大于等于 target 的最短子数组
 *
 * 给定一个含有n个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0
 *
 * 1 <= target <= 10e9
 * 1 <= nums.length <= 10e5
 * 1 <= nums[i] <= 10e5
 */
public class O008 {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7,new int[]{2,3,1,2,4,3}));
//        System.out.println(minSubArrayLen(9,new int[]{1,1,1,1,1,1,1}));
    }

    private static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int left =0,right = 0,sum=0;
        while (right < n){
            sum += nums[right];
            while (sum >= target){
                ans = Math.min(ans,right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
