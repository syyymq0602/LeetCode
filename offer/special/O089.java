package offer.special;

/**
 * 剑指 Offer II 089. 房屋偷盗
 *
 * 一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响小偷偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组 nums，请计算不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 */
public class O089 {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{2,7,9,3,1}));
    }

    private static int rob(int[] nums) {
        int len = nums.length;
        if(len == 1){
            return nums[0];
        }
        if(len == 2){
            return Math.max(nums[0],nums[1]);
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2] + nums[i]);
        }
        return dp[len-1];
    }
}
