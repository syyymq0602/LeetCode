package DP.scripts;

/**
 * 97. 交错字符串
 *
 * 给定三个字符串s1、s2、s3，请你帮忙验证s3是否是由s1和s2 交错 组成的。
 * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
 * 注意：a + b 意味着字符串 a 和 b 连接
 *
 * 0 <= s1.length, s2.length <= 100
 * 0 <= s3.length <= 200
 * s1、s2、和 s3 都由小写英文字母组成
 */
public class DP97 {
    public static void main(String[] args) {
        System.out.println(isInterleave("a","dbbcabb","dbbcaabb"));
    }

    private static boolean isInterleave(String s1, String s2, String s3) {
        int p = s1.length();
        int q = s2.length();
        int m = s3.length();
        if(p + q != m){
            return false;
        }
        boolean[][] dp = new boolean[p+1][q+1];
        dp[0][0] = true;
        for (int i = 1; i <= q; i++) {
            dp[0][i] = dp[0][i-1] && s2.charAt(i-1) == s3.charAt(i-1);
        }
        for (int i = 1; i <= p; i++) {
            dp[i][0] = dp[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);
        }
        for (int i = 1; i <= p ; i++) {
            for (int j = 1; j <= q; j++) {
                int t = i + j - 1;
                boolean temp = (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(t)) || (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(t));
                dp[i][j] = dp[i][j] || temp;
            }
        }

        return dp[p][q];
    }
}
