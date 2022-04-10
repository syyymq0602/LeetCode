package offer.scripts;

import java.util.Hashtable;
import java.util.Map;

/**
 * 剑指 Offer 50. 第一个只出现一次的字符
 *
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母
 *
 * 0 <= s 的长度 <= 50000
 */
public class o50 {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("abaccdeff"));
    }

    private static char firstUniqChar(String s) {
        if (s.length() == 0){
            return ' ';
        }
        Map<Character,Integer> set = new Hashtable<>();
        for (int i = 0; i < s.length(); i++) {
            set.put(s.charAt(i),set.getOrDefault(s.charAt(i),0)+1);
        }
        for (int i = 0; i < s.length(); i++) {
            if(set.get(s.charAt(i)) == 1){
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
