package offer.special;

/**
 * 剑指 Offer II 092. 翻转字符
 *
 * 如果一个由'0' 和 '1'组成的字符串，是以一些 '0'（可能没有 '0'）后面跟着一些 '1'
 * （也可能没有 '1'）的形式组成的，那么该字符串是单调递增的。
 * 我们给出一个由字符 '0' 和 '1'组成的字符串 s，我们可以将任何'0' 翻转为'1'或者将'1'翻转为'0'。
 * 返回使 s单调递增的最小翻转次数
 *
 * 1 <= s.length <= 20000
 * s 中只包含字符 '0' 和 '1'
 */
public class O092 {
    public static void main(String[] args) {
        System.out.println(minFlipsMonoIncr("00011000"));
    }

    private static int minFlipsMonoIncr(String s) {
        int len = s.length();
        int[][] dp = new int[len][2];
        // 第二位表示当前字符为0还是1
        dp[0][0] = s.charAt(0) == '0' ? 0:1;
        dp[0][1] = s.charAt(0) == '1' ? 0:1;
        for (int i = 1; i < len; i++) {
            if(s.charAt(i) == '0'){
                dp[i][0] = dp[i-1][0];
                dp[i][1] = Math.min(dp[i-1][1],dp[i-1][0])+1;
            }else {
                dp[i][0] = dp[i-1][0] + 1;
                dp[i][1] = Math.min(dp[i-1][0],dp[i-1][1]);
            }
        }
        return Math.min(dp[len-1][0],dp[len-1][1]);
    }
}
