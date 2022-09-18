package offer.ZhongJinSuo;

import java.util.Stack;

/**
 * 超级计算器  带 加减乘除括号
 */
public class z1 {
    public static void main(String[] args) {
        System.out.println(calculate("(2+6*3+5-(3*14/7+2)*5)+3"));
    }

    public static int calculate(String s) {
        Stack<String> stack = new Stack<>();
        //补一个左括号，最后当做有括号处理
        stack.push("(");
        int n = s.length();
        int j = 0;
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)) continue;
            if(i>j)stack.push(s.substring(j,i));

            j = i+1;
            if(c == ')'){
                //先拆掉所有括号
                calculateNoBacket(stack);
            }else{
                stack.push(String.valueOf(c));
            }
        }
        //最后非括号情况会有数字，补一个数
        if(j<n) stack.push(s.substring(j,n));
        //计算整个无括号表达式
        calculateNoBacket(stack);
        return Integer.parseInt(stack.peek());
    }

    /**
     * 拆括号，拆出当前位置到上一个左括号的表达式
     */
    private static void calculateNoBacket(Stack<String> stack){
        Stack<String> tmp = new Stack<>();
        boolean hasMulDiv = false;
        while (!"(".equals(stack.peek())){
            if(stack.peek().equals("*") || "/".equals(stack.peek()))
                hasMulDiv = true;
            tmp.push(stack.pop());
        }
        stack.pop();


        if(hasMulDiv) calculateMulDiv(tmp);
        int num = calculateAddSub(tmp);
        stack.push(String.valueOf(num));
    }

    /**
     * 算加减，负数也不用特别处理（因为必然拿到前面是0）
     */
    private static int calculateAddSub(Stack<String> stack){
        int num = 0;
        while (!stack.isEmpty()){
            String str = stack.pop();
            if(!"+".equals(str) && !"-".equals(str)){
                num = Integer.parseInt(str);
                continue;
            }

            int num2 = Integer.parseInt(stack.pop());
            if("+".equals(str)){
                num = num+num2;
            }else{
                num = num-num2;
            }
        }
        return num;
    }

    /**
     * 算乘除，非乘除号的都不管（注意，不用处理负数，最后加减会处理，(-5)*3=-(5*3),不影响结果）
     * 乘除号的算出结果放左侧栈
     * 最后需放回到原始栈
     */
    private static void calculateMulDiv(Stack<String> stack){
        Stack<String> tmp = new Stack<>();
        while (!stack.isEmpty()){
            String str = stack.pop();
            if (!"*".equals(str) && !"/".equals(str)){
                tmp.push(str);
                continue;
            }
            int numA = Integer.parseInt(tmp.pop());
            int numB = Integer.parseInt(stack.pop());

            if("*".equals(str)){
                tmp.push(String.valueOf(numA*numB));
            }else{
                tmp.push(String.valueOf(numA/numB));
            }

        }

        while (!tmp.isEmpty()){
            stack.push(tmp.pop());
        }
    }

}
