package DP.scripts;

public class DP5 {
    public static void main(String[] args) {
        String input = "babad";
        System.out.println(longestPalindrome(input));
    }

    /**
     * 5. 最长回文子串
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int len = s.length();
        if(len == 1){
            return s;
        }
        int maxLength = 1;
        int beginIndex = 0;
        int j;
        // dp[i][j]表示s 从i到j是不是回文数
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        char[] charArray = s.toCharArray();
        for (int L = 2; L < len+1; L++) {
            for (int i = 0; i < len; i++) {
                j = i + L-1;
                if(j>=len){
                    break;
                }
                if(charArray[i] != charArray[j]){
                    dp[i][j] = false;
                }else {
                    if(j-i<=2){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if(dp[i][j]&&j-i+1>maxLength){
                    maxLength = j-i+1;
                    beginIndex = i;
                }
            }
        }
        return s.substring(beginIndex,beginIndex+maxLength);
    }
}
