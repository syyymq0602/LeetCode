package DP.scripts;

/**
 * 474. 一和零
 *
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 *
 * 1 <= strs.length <= 600
 * 1 <= strs[i].length <= 100
 * strs[i]仅由'0' 和'1' 组成
 * 1 <= m, n <= 100
 */
public class DP474 {
    public static void main(String[] args) {
        System.out.println(findMaxForm(new String[]{"10", "0001", "111001", "1", "0"},5,3));
    }

    private static int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        // 前i个字符串凑成最多m个0和n个1的最大长度
        int[][][] dp = new int[len+1][m+1][n+1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <=n; j++) {
                dp[0][i][j] = 0;
            }
        }
        for (int i = 1; i <= len; i++) {
            int[] zerosOnes = getZerosOnes(strs[i - 1]);
            int zeros = zerosOnes[0], ones = zerosOnes[1];
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (j >= zeros && k >= ones) {
                        dp[i][j][k] = Math.max(dp[i-1][j][k], dp[i - 1][j - zeros][k - ones] + 1);
                    }
                }
            }
        }
        return dp[len][m][n];
    }

    private static int[] getZerosOnes(String str) {
        int[] zerosOnes = new int[2];
        int length = str.length();
        for (int i = 0; i < length; i++) {
            zerosOnes[str.charAt(i) - '0']++;
        }
        return zerosOnes;
    }
}
