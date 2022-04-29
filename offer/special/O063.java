package offer.special;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 剑指 Offer II 063. 替换单词
 *
 * 在英语中，有一个叫做词根(root) 的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为继承词(successor)。
 * 例如，词根an，跟随着单词other(其他)，可以形成新的单词another(另一个)。
 * 现在，给定一个由许多词根组成的词典和一个句子，需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
 * 需要输出替换之后的句子
 *
 * 1 <= dictionary.length<= 1000
 * 1 <= dictionary[i].length <= 100
 * dictionary[i]仅由小写字母组成。
 * 1 <= sentence.length <= 10^6
 * sentence仅由小写字母和空格组成。
 * sentence 中单词的总量在范围 [1, 1000] 内。
 * sentence 中每个单词的长度在范围 [1, 1000] 内。
 * sentence 中单词之间由一个空格隔开。
 * sentence没有前导或尾随空格
 */
public class O063 {
    public static void main(String[] args) {
        List<String> dic = new ArrayList<>();
        dic.add("cat");
        dic.add("bat");
        dic.add("rat");
        System.out.println(replaceWords(dic,"the cattle was rattled by the battery"));
    }

    private static String replaceWords(List<String> dictionary, String sentence) {
        Set<String> set = new HashSet<>();
        for (String root:dictionary) {
            set.add(root);
        }
        StringBuilder builder = new StringBuilder();
        for (String word : sentence.split(" ")){
            String prefix = "";
            for (int i = 1; i <= word.length() ; i++) {
                prefix = word.substring(0,i);
                if(set.contains(prefix)){
                    break;
                }
            }
            builder.append(prefix).append(" ");
        }
        return builder.toString().trim();
    }
}
