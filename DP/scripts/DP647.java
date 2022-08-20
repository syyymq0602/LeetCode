package DP.scripts;

/**
 * 647. 回文子串
 *
 * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 * 回文字符串 是正着读和倒过来读一样的字符串。
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 * 1 <= s.length <= 1000
 * s 由小写英文字母组成
 */
public class DP647 {
    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
    }

    private static int countSubstrings(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if(s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[j+1][i-1])){
                    dp[j][i] = true;
                    ans++;
                }
            }
        }

        return ans;
    }
}
