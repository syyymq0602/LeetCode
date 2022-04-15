package offer.special;

/**
 * 剑指 Offer II 020. 回文子字符串的个数
 *
 * 给定一个字符串 s ，请计算这个字符串中有多少个回文子字符串。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串
 *
 * 1 <= s.length <= 1000
 * s 由小写英文字母组成
 */
public class O020 {
    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
    }

    private static int countSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0 ; j--) {
                if(s.charAt(i) == s.charAt(j)){
                    if(i - j <= 1){
                        dp[i][j] = true;
                        ans++;
                    }else if(dp[i-1][j+1]){
                        dp[i][j] = true;
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}
