package DP.scripts;

import java.util.Objects;

/**
 * 10. 正则表达式匹配
 * 给你一个字符串s和一个字符规律p，请你来实现一个支持 '.'和'*'的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖整个字符串s的，而不是部分字符串。
 *
 * 1 <= s.length<= 20
 * 1 <= p.length<= 30
 * s 只含小写英文字母。
 * p只含小写英文字母，以及字符.和*。
 * 保证每次出现字符 * 时，前面都匹配到有效的字符
 *
 * dp[i][j]表示s的前i个字符与p中的前j个字符是否能够匹配
 * 状态方程: dp[i][j] = dp[i-1][j-1] ^ (s[i] == p[j])
 *         dp[i][j] = dp[i−1][j] || dp[i][j−2], s[i] = p[j-1]
 *         dp[i][j] = dp[i][j−2], s[i] != p[j-1]
 */
public class DP10 {
    public static void main(String[] args) {
        var s = "aab";
        var p = "c*a*b";
        System.out.println(isMatch(s,p));
    }

    public static boolean isMatch(String s, String p) {
        var m = s.length();
        var n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i][j-2];
                    if(matches(s,p,i,j-1)){
                        dp[i][j] = dp[i][j] || dp[i-1][j];
                    }
                }else {
                    if(matches(s,p,i,j)){
                        dp[i][j] = dp[i-1][j-1];
                    }
                }
            }
        }
        return dp[m][n];
    }

    private static boolean matches(String s,String p,int i,int j){
        if(Objects.equals(i,0)){
            return false;
        }
        if(p.charAt(j-1) == '.'){
            return true;
        }
        return s.charAt(i-1) == p.charAt(j-1);
    }
}
