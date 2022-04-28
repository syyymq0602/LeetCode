package offer.special;

import java.util.Arrays;
import java.util.Objects;

/**
 * 剑指 Offer II 065. 最短的单词编码
 *
 * 单词数组words 的 有效编码 由任意助记字符串 s 和下标数组 indices 组成，且满足：
 * words.length == indices.length
 * 助记字符串 s 以 '#' 字符结尾
 * 对于每个下标 indices[i] ，s 的一个从 indices[i] 开始、到下一个 '#' 字符结束（但不包括 '#'）的 子字符串 恰好与 words[i] 相等
 * 给定一个单词数组words ，返回成功对 words 进行编码的最小助记字符串 s 的长度
 *
 * 1 <= words.length <= 2000
 * 1 <= words[i].length <= 7
 * words[i] 仅由小写字母组成
 */
public class O065 {
    public static void main(String[] args) {
        System.out.println(minimumLengthEncoding(new String[]{"time", "me", "bell"}));
    }

    private static int minimumLengthEncoding(String[] words) {
        int len = 0;
        TrieNode trieNode = new TrieNode();
        Arrays.sort(words,(s1,s2)->s2.length() - s1.length());
        for (String word : words){
            TrieNode cur = trieNode;
            len += cur.getStringPrefix(word);
        }
        return len;
    }

    private static class TrieNode{
        TrieNode[] children;
        int count;
        boolean isEnd;

        public TrieNode(){
            children = new TrieNode[26];
            count = 0;
            isEnd = false;
        }

        public int getStringPrefix(String word) {
            char[] chars = word.toCharArray();
            count = 0;
            TrieNode tn = this;
            for (int i = chars.length-1; i >= 0; i--) {
                if(tn.children[chars[i] - 'a'] == null){
                    tn.children[chars[i] - 'a'] = new TrieNode();
                }
                count++;
                tn = tn.children[chars[i] - 'a'];
            }
            if(Arrays.stream(tn.children).anyMatch(Objects::nonNull) || tn.isEnd){
                return 0;
            }
            tn.isEnd = true;
            return count+1;
        }
    }
}
