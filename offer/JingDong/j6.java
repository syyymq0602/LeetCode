package offer.JingDong;

import java.util.Scanner;
import java.util.Stack;

public class j6 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextLine()) {
            String s = cin.nextLine();
            int len = s.length();
            int[] mem = new int[len+1];
            for (int i = 0; i < len; i++) {
                int count = 0;
                Stack<Character> stack = new Stack<>();
                stack.push(s.charAt(i));
                for (int j = i+1; j < len; j++) {
                    if(!stack.isEmpty() && s.charAt(j) == ')' && stack.peek() == '('){
                        count += 2;
                        stack.pop();
                    }else {
                        stack.push(s.charAt(j));
                    }
                    mem[count]++;
                }
            }
            int ans = 0;
            for (int i = 2; i <= len ; i++) {
                if(mem[i] == 0){
                    continue;
                }
                ans += i * mem[i];
            }
            System.out.println(ans);
        }
    }
}
