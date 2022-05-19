package offer.special;

/**
 * 剑指 Offer II 104. 排列的数目
 *
 * 给定一个由 不同正整数组成的数组 nums ，和一个目标整数 target 。请从 nums 中找出并返回总和为 target 的元素组合的个数。
 * 数组中的数字可以在一次排列中出现任意次，但是顺序不同的序列被视作不同的组合。
 * 题目数据保证答案符合 32 位整数范围
 *
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 1000
 * nums 中的所有元素 互不相同
 * 1 <= target <= 1000
 */
public class O104 {
    public static void main(String[] args) {
        System.out.println(combinationSum4(new int[]{1,2,3},4));
    }

    private static int combinationSum4(int[] nums, int target) {
        // 用 dp[x] 表示选取的元素之和等于 x 的方案数，目标是求 dp[target]
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
