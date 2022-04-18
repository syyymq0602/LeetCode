package offer.special;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 剑指 Offer II 036. 后缀表达式
 *
 * 根据 逆波兰表示法，求该后缀表达式的计算结果。
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式
 *
 * 说明：
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况
 *
 * 1 <= tokens.length <= 10e4
 * tokens[i] 要么是一个算符（"+"、"-"、"*" 或 "/"），要么是一个在范围 [-200, 200] 内的整数
 *
 * 逆波兰表达式：
 * 逆波兰表达式是一种后缀表达式，所谓后缀就是指算符写在后面。
 * 平常使用的算式则是一种中缀表达式，如 ( 1 + 2 ) * ( 3 + 4 ) 。
 * 该算式的逆波兰表达式写法为 ( ( 1 2 + ) ( 3 4 + ) * ) 。
 * 逆波兰表达式主要有以下两个优点：
 * 去掉括号后表达式无歧义，上式即便写成 1 2 + 3 4 + * 也可以依据次序计算出正确结果。
 * 适合用栈操作运算：遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中
 */
public class O036 {
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }

    private static int evalRPN(String[] tokens) {
        Set<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if(!set.contains(tokens[i])){
                stack.push(Integer.parseInt(tokens[i]));
            }else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                int res = calc(num1,num2,tokens[i]);
                stack.push(res);
            }
        }
        return stack.pop();
    }

    private static int calc(int num2, int num1, String token) {
        if ("+".equals(token)){
            return num1 + num2;
        }else if("-".equals(token)){
            return num1 - num2;
        }else if("*".equals(token)){
            return num1 * num2;
        }else {
            return num1 / num2;
        }
    }
}
