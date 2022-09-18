package offer.TongCheng;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class t1 {
    public static void main(String[] args) {
        System.out.println(longestPrefix("ababab"));
    }

    public static String longestPrefix (String s) {
        // write code here
        int len = s.length();
        Set<String> set = new HashSet<>();
        for (int i = 1; i < len; i++) {
            String temp = s.substring(0,i);
            set.add(temp);
        }
        String ans = "";
        for (int i = 1; i < len; i++) {
            String t2 = s.substring(i,len);
            if(set.contains(t2)){
                ans = t2;
                break;
            }
        }
        return ans;
    }
}
