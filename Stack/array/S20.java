package Stack.array;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合
 *
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 */
public class S20 {
    public static void main(String[] args) {
        var s = "()[(])";
        System.out.println(isValid(s));
    }

    private static boolean isValid(String s) {
        int n = s.length();
        if(n%2 == 1){
            return false;
        }
        Map<Character,Character> map = new HashMap<>(){
            {
                put('}','{');
                put(']','[');
                put(')','(');
            }
        };
        char[] array = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = array[i];
            if(map.containsKey(c)){
                char temp = stack.isEmpty() ? '#':stack.pop();
                if(temp != map.get(c)){
                    return false;
                }
            }else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
