package string.scripts;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 567. 字符串的排列
 *
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 *
 * 换句话说，s1 的排列之一是 s2 的 子串
 *
 * 1 <= s1.length, s2.length <= 104
 * s1 和 s2 仅包含小写字母
 */
public class S567 {
    public static void main(String[] args) {
        var s1 = "adc";
        var s2 = "decda";
        System.out.println(checkInclusion1(s1,s2));
    }

    private static boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> map = new HashMap<>();
        int m = s1.length();
        int n = s2.length();
        if(m>n){
            return false;
        }
        for (int i = 0; i < m; i++) {
            map.put(s1.charAt(i),map.getOrDefault(s1.charAt(i),0)+1);
        }
        for (int i = 0; i < n; i++) {
            if(!map.containsKey(s2.charAt(i))){
                continue;
            }
            if(i+m<n){
                if(judge(s2.substring(i,i+m),map)){
                    return true;
                }
            }

        }
        return false;
    }

    private static boolean checkInclusion1(String s1, String s2){
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < n; ++i) {
            ++cnt1[s1.charAt(i) - 'a'];
            ++cnt2[s2.charAt(i) - 'a'];
        }
        if (Arrays.equals(cnt1, cnt2)) {
            return true;
        }
        for (int i = n; i < m; ++i) {
            ++cnt2[s2.charAt(i) - 'a'];
            --cnt2[s2.charAt(i - n) - 'a'];
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean judge(String s, Map<Character, Integer> map) {
        Map<Character,Integer> clone = new HashMap<>(map);
        for (int i = 0; i < s.length(); i++) {
            clone.put(s.charAt(i),clone.getOrDefault(s.charAt(i),0)-1);
        }
        for (Map.Entry<Character, Integer> entry : clone.entrySet()) {
            if(entry.getValue()!=0){
                return false;
            }
        }
        return true;
    }
}
