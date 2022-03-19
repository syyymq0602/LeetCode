package string.scripts;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 242. 有效的字母异位词
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 *
 * 1 <= s.length, t.length <= 5 * 104
 * s 和 t 仅包含小写字母
 */
public class S242 {
    public static void main(String[] args) {
        var s = "anagram";
        var t = "nagaram";
        System.out.println(isAnagram(s,t));
    }

    private static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            arr[t.charAt(i) - 'a']--;
            if(arr[t.charAt(i) - 'a']<0){
                return false;
            }
        }
        return true;
    }
}
