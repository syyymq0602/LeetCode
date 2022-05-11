package offer.special;

import java.util.Arrays;

/**
 * 剑指 Offer II 102. 加减的目标值
 *
 * 给定一个正整数数组 nums 和一个整数 target 。
 * 向数组中的每个整数前添加'+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目
 *
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 1000
 * 0 <= sum(nums[i]) <= 1000
 * -1000 <= target <= 1000
 */
public class O102 {
    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1,1,1,1,1},3));
    }

    private static int ans;

    private static int findTargetSumWays(int[] nums, int target) {
        ans = 0;
        Arrays.sort(nums);
        dfs(nums,target,0);
        return ans;
    }

    private static void dfs(int[] nums, int target, int pos) {
        if(pos == nums.length){
            if(target == 0){
                ans++;
            }
            return;
        }
        target = target - nums[pos];
        dfs(nums,target,pos+1);
        target = target + nums[pos];
        dfs(nums,target + nums[pos],pos+1);
    }
}
