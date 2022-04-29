package offer.special;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 064. 神奇的字典
 *
 * 设计一个使用单词列表进行初始化的数据结构，单词列表中的单词 互不相同 。
 * 如果给出一个单词，请判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单词存在于已构建的神奇字典中。
 *
 * 实现 MagicDictionary 类：
 * MagicDictionary() 初始化对象
 * void buildDict(String[]dictionary) 使用字符串数组dictionary 设定该数据结构，dictionary 中的字符串互不相同
 * bool search(String searchWord) 给定一个字符串 searchWord ，判定能否只将字符串中 一个 字母换成另一个字母，
 * 使得所形成的新字符串能够与字典中的任一字符串匹配。如果可以，返回 true ；否则，返回 false
 *
 * 1 <=dictionary.length <= 100
 * 1 <=dictionary[i].length <= 100
 * dictionary[i] 仅由小写英文字母组成
 * dictionary 中的所有字符串 互不相同
 * 1 <=searchWord.length <= 100
 * searchWord 仅由小写英文字母组成
 * buildDict 仅在 search 之前调用一次
 * 最多调用 100 次 search
 */
public class O064 {
    public static void main(String[] args) {
        var md = new MagicDictionary();
        md.buildDict(new String[]{"hello", "leetcode"});
        System.out.println(md.search("leetcodd"));
    }

    private static class MagicDictionary {
        Map<Integer, ArrayList<String>> buckets;
        public MagicDictionary() {
            buckets = new HashMap();
        }

        public void buildDict(String[] words) {
            for (String word: words) {
                buckets.computeIfAbsent(word.length(), x -> new ArrayList()).add(word);
            }
        }

        public boolean search(String word) {
            if (!buckets.containsKey(word.length())) return false;
            for (String candidate: buckets.get(word.length())) {
                int mismatch = 0;
                for (int i = 0; i < word.length(); ++i) {
                    if (word.charAt(i) != candidate.charAt(i)) {
                        if (++mismatch > 1) break;
                    }
                }
                if (mismatch == 1) return true;
            }
            return false;
        }
    }
}
