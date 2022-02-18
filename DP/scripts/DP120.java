package DP.scripts;

import java.util.*;

/**
 * 120. 三角形最小路径和
 *
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 *
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -104 <= triangle[i][j] <= 104
 *
 */
public class DP120 {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>(List.of(-1)));
        triangle.add(new ArrayList<>(List.of(2,3)));
        triangle.add(new ArrayList<>(List.of(1,-1,-3)));
        triangle.add(new ArrayList<>(List.of(4,1,8,3)));
        System.out.println(minimumTotal(triangle));
    }

    private static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i-1]+triangle.get(i).get(i);
            for (int j = i-1; j > 0; j--) {
                dp[j] = Math.min(dp[j-1],dp[j]) + triangle.get(i).get(j);
            }
            dp[0] += triangle.get(i).get(0);
        }
        int min = dp[0];
        for (int i = 1; i < dp.length; i++) {
            min = Math.min(min,dp[i]);
        }
        return min;
    }

}
