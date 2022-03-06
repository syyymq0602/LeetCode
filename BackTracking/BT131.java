package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. 分割回文串
 *
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * 回文串 是正着读和反着读都一样的字符串。
 *
 * 1 <= s.length <= 16
 * s 仅由小写英文字母组成
 */
public class BT131 {
    public static void main(String[] args) {
        var s = "aab";
        List<List<String>> lists = partition(s);
        for (var items:lists) {
            var out = "";
            for (var item:items) {
                out += item + " ";
            }
            System.out.println(out);
        }
    }

    private static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        dfs(ans,temp,s,0);
        return ans;
    }

    private static void dfs(List<List<String>> ans, List<String> temp,String s, int pos) {
        if(pos >= s.length()){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = pos; i < s.length(); i++) {
            String sub = s.substring(pos,i+1);
            if(!isValid(sub)){
                continue;
            }
            temp.add(sub);
            dfs(ans,temp,s,i+1);
            temp.remove(temp.size()-1);
        }
    }

    private static boolean isValid(String s) {
        boolean valid = true;
        int start = 0;
        int end = s.length()-1;
        while (start <= end){
            if(s.charAt(start) != s.charAt(end)){
                valid = false;
                break;
            }
            start++;
            end--;
        }
        return valid;
    }
}
