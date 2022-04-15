package offer.special;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 014. 字符串中的变位词
 *
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的某个变位词。
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串
 *
 * 1 <= s1.length, s2.length <= 10e4
 * s1 和 s2 仅包含小写字母
 */
public class O014 {
    public static void main(String[] args) {
        System.out.println(checkInclusion("ab","eidboaoo"));
    }

    private static boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if(n1 > n2){
            return false;
        }
        int[] cs1 = new int[26];
        int[] cs2 = new int[26];
        for (int i = 0; i < n1; i++) {
            ++cs1[s1.charAt(i) - 'a'];
            ++cs2[s2.charAt(i) - 'a'];
        }
        if(Arrays.equals(cs1,cs2)){
            return true;
        }
        for (int i = n1; i < n2; i++) {
            ++cs2[s2.charAt(i) - 'a'];
            --cs2[s2.charAt(i-n1) - 'a'];
            if(Arrays.equals(cs1,cs2)){
                return true;
            }
        }
        return false;
    }

    private static boolean checkInclusion(String sub,Map<Character,Integer> map){
        Map<Character,Integer> clone = new HashMap<>(map);
        for (int i = 0; i < sub.length(); i++) {
            if(!clone.containsKey(sub.charAt(i))){
                return false;
            }
            clone.put(sub.charAt(i),clone.get(sub.charAt(i))-1);
        }
        for (Map.Entry<Character, Integer> entry : clone.entrySet()) {
            if(entry.getValue() != 0){
                return false;
            }
        }
        return true;
    }
}
