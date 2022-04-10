package DP.scripts;

/**
 * 72. 编辑距离
 *
 * 给你两个单词word1 和word2， 请返回将word1转换成word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 *  <= word1.length, word2.length <= 500
 *  word1 和 word2 由小写英文字母组成
 */
public class DP72 {
    public static void main(String[] args) {
        System.out.println(minDistance("a","b"));
    }

    private static int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if(m * n == 0){
            return m+n;
        }
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i < n+1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < m+1; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                int left = dp[i - 1][j]+1;
                int down = dp[i][j - 1]+1;
                int left_down = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)){
                    left_down +=1;
                }
                dp[i][j] = Math.min(left,Math.min(down,left_down));
            }
        }
        return dp[n][m];
    }
}
