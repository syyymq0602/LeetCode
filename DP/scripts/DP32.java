package DP.scripts;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 32. 最长有效括号
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * 0 <= s.length <= 3 * 104
 * s[i] 为 '(' 或 ')'
 *
 * (((()())))
 * 0 0 0 0 2 0 4 6 8 10
 * 0 1 2 3 4 5 6 7 8 9
 *
 * dp[i] = dp[i-2]+2 or (dp[i-1]+dp[i-dp[i-1]-2]+2)
 */
public class DP32 {
    public static void main(String[] args) {
        var s = "(()())";
        System.out.println(longestValidParentheses(s));
    }

    public static int longestValidParentheses(String s) {
        var len = s.length();
        if(len == 0 || len == 1){
            return 0;
        }
        int[] dp = new int[len];
        int max = 0;
        for (int i = 1; i < len; i++) {
            if(s.charAt(i) == ')'){
                if(s.charAt(i-1) == '('){
                    dp[i] = (i-2>0?dp[i-2]:0) + 2;
                }else if(i-dp[i-1]>0&&s.charAt(i-dp[i-1]-1) == '('){
                    dp[i] = dp[i-1]+((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                max = Math.max(max,dp[i]);
            }
        }
        return max;
    }

    public static int longestValidParentheses2(String s){
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                stack.push(i);
            }else {
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else {
                    maxans = Math.max(maxans,i-stack.peek());
                }
            }
        }
        return maxans;
    }
}
