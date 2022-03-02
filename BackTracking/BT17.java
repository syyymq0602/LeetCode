package BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 * <p>
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 */
public class BT17 {
    public static void main(String[] args) {
        var digits = "23";
        System.out.println(letterCombinations(digits).size());
    }

    private static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0){
            return ans;
        }
        Map<Character, String> phoneMap = new HashMap<>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        dfs(ans,phoneMap,digits,0,new StringBuilder());
        return ans;
    }

    private static void dfs(List<String> ans, Map<Character, String> phoneMap, String digits, int i, StringBuilder stringBuilder) {
        if(i == digits.length()){
            ans.add(stringBuilder.toString());
            return;
        }else {
            char letter = digits.charAt(i);
            String letters = phoneMap.get(letter);
            int lettersCount = letters.length();
            for (int j = 0; j < lettersCount; j++) {
                stringBuilder.append(letters.charAt(j));
                dfs(ans,phoneMap,digits,i+1,stringBuilder);
                stringBuilder.deleteCharAt(i);
            }
        }
    }
}
