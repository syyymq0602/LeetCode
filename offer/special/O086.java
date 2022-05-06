package offer.special;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剑指 Offer II 086. 分割回文子字符串
 *
 * 给定一个字符串 s ，请将 s 分割成一些子串，使每个子串都是 回文串 ，返回 s 所有可能的分割方案。
 * 回文串 是正着读和反着读都一样的字符串
 *
 * 1 <= s.length <= 16
 * s 仅由小写英文字母组成
 */
public class O086 {
    public static void main(String[] args) {
        var ans = partition("google");
        for (var item : ans){
            System.out.println(Arrays.toString(item));
        }
    }

    private static String[][] partition(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        // 预处理
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = true;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = (arr[i] == arr[j] && dp[i + 1][j - 1]);
            }
        }
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        dfs(res, path, s, n, dp, 0);
        // List<List<String>> 转 String[][]，这里不重要
        String[][] ans = new String[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = new String[res.get(i).size()];
            for (int j = 0; j < ans[i].length; j++) {
                ans[i][j] = res.get(i).get(j);
            }
        }
        return ans;
    }

    public static void dfs(List<List<String>> res, List<String> path, String s, int n, boolean[][] dp, int pos) {
        if (pos == n) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = pos; i < n; i++) {
            // s[pos:i] （闭区间）是一个回文，所以递归搜索s[i+1, s.length()-1]
            if (dp[pos][i]) {
                path.add(s.substring(pos, i + 1));
                dfs(res, path, s, n, dp, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }
}
