package DP.scripts;

import java.util.Objects;

/**
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * n == height.length
 * 1 <= n <= 2 * 104
 * 0 <= height[i] <= 105
 *
 * 动态方程: 1 <= i <= n-1时，leftMax[i]=max(leftMax[i-1],height[i])
 * 动态方程: 0 <= i <= n-2时，rightMax[i]=max(rightMax[i+1],height[i])
 * 动态方程: ans = min(leftMax[i],rightMax[i]) - height[i]
 */
public class DP42 {
    public static void main(String[] args) {
        var height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        int n = height.length;
        if(Objects.equals(n,0)){
            return 0;
        }
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i-1],height[i]);
        }

        int[] rightMax = new int[n];
        rightMax[n-1] = height[n-1];
        for (int i = n-2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1],height[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(leftMax[i],rightMax[i])-height[i];
        }
        return ans;
    }
}
