package offer.BaiDu;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class b1 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextLine()){
            String s = cin.nextLine();
            char[] chars = s.toCharArray();
            int len = chars.length;
            int count = 0;
            for (int i = 0; i < len; i++) {
                int end = i + 5;
                if(end > len){
                    continue;
                }
                String temp = s.substring(i,end);
                if(judgeString(temp)){
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    private static boolean judgeString(String s){
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()){
            set.add(c);
        }
        if(set.size() != 5){
            return false;
        }
        if(!judge(s.charAt(0)) && judge(s.charAt(1))&&judge(s.charAt(2))&&!judge(s.charAt(3))&&judge(s.charAt(4))){
            return true;
        }
        return false;
    }

    private static boolean judge(char ch){
        int ans = ch - 'a';
        if(ans == 0 || ans == 4 || ans == 8 || ans == 14 || ans == 20){
            return true;
        }
        return false;
    }
}
