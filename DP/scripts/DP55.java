package DP.scripts;

/**
 * 55. 跳跃游戏
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标。
 *
 * 1 <= nums.length <= 3 * 104
 * 0 <= nums[i] <= 105
 *
 *贪心算法
 */
public class DP55 {
    public static void main(String[] args) {
        var nums = new int[]{0};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int len = nums.length;
        if(len == 1){
            return true;
        }
        int rightMax = 0;
        for (int i = 0; i < len; i++) {
            if(i<=rightMax){
                rightMax = Math.max(rightMax,i+nums[i]);
                if(rightMax>=len){
                    return true;
                }
            }
        }
        return false;
    }
}
