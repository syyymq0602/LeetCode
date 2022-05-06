package offer.special;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer II 085. 生成匹配的括号
 *
 * 正整数 n 代表生成括号的对数，请设计一个函数，用于能够生成所有可能的并且 有效的 括号组合
 *
 * 1 <= n <= 8
 */
public class O085 {
    public static void main(String[] args) {
        var ans = generateParenthesis(3);
        System.out.println(ans.toString());
    }

    private static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        dfs(ans,n,0,0,builder);
        return ans;
    }

    private static void dfs(List<String> ans, int n, int left, int right, StringBuilder builder) {
        if(right > left || left > n){
            return;
        }
        if(builder.length() == 2 * n){
            ans.add(builder.toString());
            return;
        }
        dfs(ans,n,left+1,right,builder.append('('));
        builder.deleteCharAt(builder.length()-1);
        dfs(ans,n,left,right+1,builder.append(')'));
        builder.deleteCharAt(builder.length() -1 );
    }
}
