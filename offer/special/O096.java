package offer.special;

/**
 * 剑指 Offer II 096. 字符串交织
 *
 * 给定三个字符串s1、s2、s3，请判断s3能不能由s1和s2交织（交错）组成。
 * 两个字符串 s 和 t 交织的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * 交织 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
 * 提示：a + b 意味着字符串 a 和 b 连接
 *
 * 0 <= s1.length, s2.length <= 100
 * 0 <= s3.length <= 200
 * s1、s2、和 s3 都由小写英文字母组成
 */
public class O096 {
    public static void main(String[] args) {
        System.out.println(isInterleave("aabcc","dbbca","aadbbcbcac"));
    }

    private static boolean isInterleave(String s1, String s2, String s3) {
        int m1 = s1.length();
        int m2 = s2.length();
        int m3 = s3.length();
        if(m1 + m2 != m3){
            return false;
        }
        // dp[i][j]表示字符串s1[0 ... i - 1]与字符串s2[0 ... j - 1]能够交织成字符串s3[0 ... i + j - 1]
        boolean[][] dp = new boolean[m1+1][m2+1];
        dp[0][0] = true;
        // 当s2为空时，判断s1能否交织出s3
        for (int i = 1; i <= m1; i++) {
            dp[i][0] = s3.charAt(i-1) == s1.charAt(i-1) && dp[i-1][0];
        }
        // 当s1为空时，判断s2能否交织出s3
        for (int i = 1; i <= m2; i++) {
            dp[0][i] = s3.charAt(i-1) == s2.charAt(i-1) && dp[0][i-1];
        }

        for (int i = 1; i <= m1; i++) {
            for (int j = 1; j <= m2; j++) {
                int index = i + j -1;
                dp[i][j] = (s1.charAt(i-1) == s3.charAt(index) && dp[i-1][j]) || (s2.charAt(j-1) == s3.charAt(index) && dp[i][j-1]);
            }
        }

        return dp[m1][m2];
    }
}
