package DP.scripts;

import java.util.ArrayList;
import java.util.List;

/**
 * 140. 单词拆分 II
 *
 * 给定一个字符串 s 和一个字符串字典wordDict，在字符串s中增加空格来构建一个句子，使得句子中所有的单词都在词典中。以任意顺序 返回所有这些可能的句子。
 * 注意：词典中的同一个单词可能在分段中被重复使用多次
 *
 * 1 <= s.length <= 20
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 10
 * s和wordDict[i]仅有小写英文字母组成
 * wordDict中所有字符串都 不同
 */
public class DP140 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("cat");
        list.add("cats");
        list.add("and");
        list.add("sand");
        list.add("dog");
        System.out.println(wordBreak("catsanddog",list));
    }

    private static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
        wordBreak(s,wordDict,ans,0,new StringBuilder());
        return ans;
    }

    private static void wordBreak(String s, List<String> wordDict, List<String> ans, int index,StringBuilder builder) {
        if(index == s.length()){
            ans.add(builder.toString().trim());
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if(wordDict.contains(s.substring(index,i+1))){
                int size = builder.length();
                builder.append(s, index, i+1).append(" ");
                wordBreak(s,wordDict,ans,i+1,builder);
                builder.delete(size,builder.length());
            }
        }
    }
}
