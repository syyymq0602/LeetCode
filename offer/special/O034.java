package offer.special;

import java.util.Objects;

/**
 * 剑指 Offer II 034. 外星语言是否排序
 *
 * 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
 * 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false
 *
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * order.length == 26
 * 在words[i]和order中的所有字符都是英文小写字母
 */
public class O034 {
    public static void main(String[] args) {
        System.out.println(
                isAlienSorted(new String[]{"word","world","row"},"hlabcdefgijkmnopqrstuvwxyz"));
    }

    private static boolean isAlienSorted(String[] words, String order) {
        int[] orders = new int[26];
        for (int i = 0; i < orders.length; i++) {
            orders[order.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < words.length-1; i++) {
            if(!check(words[i],words[i+1],orders)){
                return false;
            }
        }
        return true;
    }

    private static boolean check(String word, String word1, int[] orders) {
        if(Objects.equals(word,word1)){
            return true;
        }
        if("".equals(word)){
            return true;
        }
        if("".equals(word1)){
            return false;
        }
        int len = Math.min(word.length(),word1.length());
        for (int i = 0; i < len; i++) {
            if(word.charAt(i) == word1.charAt(i)){
                continue;
            }
            if(orders[word.charAt(i) - 'a'] < orders[word1.charAt(i) - 'a']){
                return true;
            }else {
                return false;
            }
        }
        if(word1.length() > word.length()){
            return true;
        }else {
            return false;
        }
    }
}
