package DP.scripts;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * 646. 最长数对链
 * <p>
 * 给出n个数对。在每一个数对中，第一个数字总是比第二个数字小。
 * 现在，我们定义一种跟随关系，当且仅当b < c时，数对(c, d)才可以跟在(a, b)后面。我们用这种形式来构造一个数对链。
 * 给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
 * <p>
 * 给出数对的个数在 [1, 1000] 范围内
 */
public class DP646 {
    public static void main(String[] args) {
        var nums = new int[][]{
                {1, 2}, {7,8}, {3, 4}
        };
        System.out.println(findLongestChain(nums));
    }

    private static int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        int[] dp = new int[n];
        Arrays.sort(pairs, (o1, o2) -> o1[0] - o2[0]);
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
