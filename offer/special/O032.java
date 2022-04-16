package offer.special;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 剑指 Offer II 032. 有效的变位词
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断它们是不是一组变位词（字母异位词）。
 * 注意：若s 和 t中每个字符出现的次数都相同且字符顺序不完全相同，
 * 则称s 和 t互为变位词（字母异位词）
 *
 * 1 <= s.length, t.length <= 5 * 10e4
 * s and t 仅包含小写字母
 */
public class O032 {
    public static void main(String[] args) {
        System.out.println(isAnagram2("nl","cx"));
    }

    private static boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(n != m){
            return false;
        }
        if(Objects.equals(s,t)){
            return false;
        }
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)-1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue() != 0){
                return false;
            }
        }
        return true;
    }

    private static boolean isAnagram2(String s, String t){
        int n = s.length();
        int m = t.length();
        if(n != m){
            return false;
        }
        if(Objects.equals(s,t)){
            return false;
        }
        int[] record = new int[26];
        for (int i = 0; i < n; i++) {
            record[s.charAt(i) - 'a']++;
            record[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if(record[i] != 0){
                return false;
            }
        }
        return true;
    }
}
