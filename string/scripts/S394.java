package string.scripts;

import java.util.Stack;

/**
 * 394. 字符串解码
 *
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像3a或2[4]的输入。
 *
 * 1 <= s.length <= 30
 * s由小写英文字母、数字和方括号'[]' 组成
 * s保证是一个有效的输入。
 * s中所有整数的取值范围为[1, 300]
 */
public class S394 {
    public static void main(String[] args) {
        System.out.println(decodeString("100[abc]"));
    }

    private static String decodeString(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if(chars[i] != ']'){
                stack.push(chars[i]);
            }else {
                StringBuilder a = new StringBuilder();
                // 把字符串压入临时栈
                while (!stack.isEmpty() && stack.peek() != '['){
                    a.append(stack.pop());
                }
                a = a.reverse();
                // 把 '[' 出栈
                stack.pop();
                // 获取数字
                StringBuilder b = new StringBuilder();
                while (!stack.isEmpty() && judge(stack.peek())){
                    b.append(stack.pop());
                }
                // 获取重复次数
                int c = Integer.parseInt(b.reverse().toString());
                while (c-- > 0){
                    for (int j = 0; j < a.length(); j++) {
                        stack.push(a.charAt(j));
                    }
                }
            }
        }
        while (!stack.isEmpty()){
            builder.append(stack.pop());
        }
        return builder.reverse().toString();
    }

    private static boolean judge(Character peek) {
        int index = peek - '0';
        return index >= 0 && index <= 9;
    }
}
