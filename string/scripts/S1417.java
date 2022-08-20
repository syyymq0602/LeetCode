package string.scripts;

import java.util.ArrayList;
import java.util.List;

/**
 * 1417. 重新格式化字符串
 *
 * 给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。
 * 请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。
 * 请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 。
 *
 * 1 <= s.length <= 500
 * s 仅由小写英文字母和/或数字组成。
 */
public class S1417 {
    public static void main(String[] args) {
        System.out.println(reformat("a0b1c2"));
    }

    private static String reformat(String s) {
        List<Character> ch = new ArrayList<>();
        List<Character> num = new ArrayList<>();
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n; i++) {
            int acs = chars[i] - '0';
            if(acs>=0 && acs <= 10){
                num.add(chars[i]);
            }else {
                ch.add(chars[i]);
            }
        }
        if(Math.abs(ch.size() - num.size()) > 1){
            return "";
        }
        StringBuilder builder = new StringBuilder();
        if(ch.size() > num.size()){
            for (int i = 0; i < num.size(); i++) {
                builder.append(ch.get(i)).append(num.get(i));
            }
            builder.append(ch.get(ch.size()-1));
            return builder.toString();
        }else if(ch.size() == num.size()){
            for (int i = 0; i < num.size(); i++) {
                builder.append(ch.get(i)).append(num.get(i));
            }
            return builder.toString();
        }else {
            for (int i = 0; i < ch.size(); i++) {
                builder.append(num.get(i)).append(ch.get(i));
            }
            builder.append(num.get(num.size()-1));
            return builder.toString();
        }
    }
}
