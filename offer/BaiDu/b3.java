package offer.BaiDu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class b3 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while (cin.hasNextLine()){
            String ss = cin.nextLine();
            list.add(ss);
            if("}".equals(ss)){
                break;
            }
        }
        int total = list.size();
        Stack<String> stack = new Stack<>();
        int for_count = 0;
        int if_count = 0;
        for (int i = 0; i < total; i++) {
            String item = list.get(i);
            if(item.contains("for")){
                stack.push("for");
                for_count++;
            } else if (item.contains("if")) {
                stack.push("if");
                if_count++;
            } else if (!stack.isEmpty() && item.contains("}")) {
                String up = stack.peek();
                if("if".equals(up)){
                    if_count--;
                }else {
                    for_count = Math.max(for_count,stack.size() - if_count);
                }
                stack.pop();
            }
        }
        System.out.println(for_count);
    }
}
