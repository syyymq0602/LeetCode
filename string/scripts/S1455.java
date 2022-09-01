package string.scripts;

import java.util.Arrays;

/**
 * 1455. 检查单词是否为句中其他单词的前缀
 *
 * 给你一个字符串 sentence 作为句子并指定检索词为 searchWord ，
 * 其中句子由若干用 单个空格 分隔的单词组成。请你检查检索词 searchWord 是否为句子 sentence 中任意单词的前缀。
 * 如果searchWord 是某一个单词的前缀，则返回句子sentence 中该单词所对应的下标（下标从 1 开始）。
 * 如果 searchWord 是多个单词的前缀，则返回匹配的第一个单词的下标（最小下标）。如果 searchWord 不是任何单词的前缀，则返回 -1 。
 *
 * 字符串 s 的 前缀 是 s 的任何前导连续子字符串。
 *
 * 1 <= sentence.length <= 100
 * 1 <= searchWord.length <= 10
 * sentence 由小写英文字母和空格组成。
 * searchWord 由小写英文字母组成。
 */
public class S1455 {
    public static void main(String[] args) {
        System.out.println(isPrefixOfWord2("i love eating burger","burg"));
    }

    private static int isPrefixOfWord(String sentence, String searchWord) {
        int ans = -1;
        String[] ss = sentence.split(" ");
        for (int i = 0; i < ss.length; i++) {
            if(ss[i].startsWith(searchWord)){
                ans = i+1;
                break;
            }
        }
        return ans;
    }

    private static int isPrefixOfWord2(String sentence, String searchWord) {
        int ans = -1;
        int n = searchWord.length();
        String[] sentences = sentence.split(" ");
        int[] cnt = new int[26];
        for (int i = 0; i < searchWord.length(); i++) {
            cnt[searchWord.charAt(i) - 'a']++;
        }
        for (int i = 0; i < sentences.length; i++) {
            if(sentences[i].length() < n){
                continue;
            }
            int[] ant = new int[26];
            int len = 0;
            while (len < n){
                ant[sentences[i].charAt(len) - 'a']++;
                len++;
            }
            if(Arrays.equals(ant,cnt)){
                ans = i+1;
                break;
            }
        }
        return ans;
    }
}
