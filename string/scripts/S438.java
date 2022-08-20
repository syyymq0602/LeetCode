package string.scripts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 *
 * 给定两个字符串s和 p，找到s中所有p的异位词的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）
 *
 * 1 <= s.length, p.length <= 3 * 10e4
 * s 和 p 仅包含小写字母
 */
public class S438 {
    public static void main(String[] args) {
        System.out.println(findAnagrams("abab","ab"));
    }

    private static List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int m = p.length();
        List<Integer> ans = new ArrayList<>();
        if(m > n){
            return ans;
        }
        int[] a1 = new int[26];
        int[] a2 = new int[26];
        for (int i = 0; i < m; i++) {
            a1[p.charAt(i) - 'a']++;
            a2[s.charAt(i) - 'a']++;
        }
        if(Arrays.equals(a1,a2)){
            ans.add(0);
        }
        for (int i = m; i < n; i++) {
            a2[s.charAt(i) - 'a']++;
            a2[s.charAt(i-m) - 'a']--;
            if(Arrays.equals(a1,a2)){
                ans.add(i- m +1);
            }
        }
        return ans;
    }
}
