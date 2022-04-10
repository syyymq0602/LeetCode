package offer.scripts;

import java.util.Objects;

/**
 * 剑指 Offer 58 - I. 翻转单词顺序
 *
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串"I am a student. "，则输出"student. a am I"。
 *
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个
 */
public class o58_1 {
    public static void main(String[] args) {
        System.out.println(reverseWords("   1"));
    }

    private static String reverseWords(String s) {
        String[] strs = s.trim().split(" ");
        StringBuilder res = new StringBuilder();
        for(int i = strs.length - 1; i >= 0; i--) {
            if(strs[i].equals("")) continue;
            res.append(strs[i]).append(" ");
        }
        return res.toString().trim();
    }
}
