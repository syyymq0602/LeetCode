package offer.AiShu;

import java.util.Scanner;

public class a2 {
    int _a = 1;
    String str = new String("good");
    char[] ch = new char[]{'a','b','c'};
    public static void main(String[] args) {
        a2 a = new a2();
        a.change(a.str,a.ch);
        System.out.println(a.str);
        System.out.println(a.ch);
    }
    private void change(String str,char[] chars){
        str = "test";
        chars[0] = 'g';
    }
}
