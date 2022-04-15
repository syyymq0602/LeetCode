package offer.special;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 016. 不含重复字符的最长子字符串
 *
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长连续子字符串 的长度
 *
 * 0 <= s.length <= 5 * 10e4
 * s 由英文字母、数字、符号和空格组成
 */
public class O016 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    private static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int len = 0;
        if(n == 0){
            return len;
        }
        Map<Character,Integer> map = new HashMap<>();
        int left = 0,right = 0;
        while (left < n && right < n){
            if(map.getOrDefault(s.charAt(right),0) == 0){
                map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
                right++;
            }else {
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                left++;
            }
            len = Math.max(len,right-left);
        }
        return len;
    }
}
