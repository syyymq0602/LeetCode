package offer.special;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剑指 Offer II 015. 字符串中的所有变位词
 *
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 变位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 变位词 指字母相同，但排列不同的字符串
 *
 * 1 <= s.length, p.length <= 3 * 10e4
 * s 和 p 仅包含小写字母
 */
public class O015 {
    public static void main(String[] args) {
        var res = findAnagrams("abab","ab");
        System.out.println(res.toString());
    }

    private static List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int m = p.length();
        List<Integer> ans = new ArrayList<>();
        if(n < m){
            return ans;
        }
        int[] ns = new int[26];
        int[] mp = new int[26];
        for (int i = 0; i < m; i++) {
            ++mp[p.charAt(i) - 'a'];
            ++ns[s.charAt(i) - 'a'];
        }
        if(Arrays.equals(ns,mp)){
            ans.add(0);
        }
        for (int i = m; i < n; i++) {
            ++ns[s.charAt(i) - 'a'];
            --ns[s.charAt(i-m) - 'a'];
            if(Arrays.equals(ns,mp)){
                ans.add(i-m+1);
            }
        }
        return ans;
    }
}
