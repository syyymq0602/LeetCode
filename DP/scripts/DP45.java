package DP.scripts;

/**
 * 45. 跳跃游戏 II
 *
 * 给你一个非负整数数组nums ，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 1000
 */
public class DP45 {
    public static void main(String[] args) {
        var nums = new int[]{2,0,2,8};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        int len = nums.length;
        int res = 0;
        int maxPosition = 0;
        int end = 0;
        for (int i = 0; i < len-1; i++) {
            maxPosition = Math.max(maxPosition,nums[i] + i);
            if(end == i){
                res++;
                end = maxPosition;
            }
        }
        return res;
    }
}
