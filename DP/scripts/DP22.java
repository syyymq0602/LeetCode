package DP.scripts;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 1 <= n <= 8
 * 使用二叉树遍历搜索
 */
public class DP22 {

    private static final List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        int n = 1;
        for (String item:generateParenthesis(n)) {
            System.out.println(item);
        }
    }

    public static List<String> generateParenthesis(int n) {
        backtrack("",0,0,n);
        return res;
    }

    public static void backtrack(String ans, int left, int right,int n) {
        if(left>n || right>left)
            return;
        if(ans.length() == 2*n){
            res.add(ans);
            return;
        }
        backtrack(ans+"(",left+1,right,n);
        backtrack(ans+")",left,right+1,n);
    }
}
