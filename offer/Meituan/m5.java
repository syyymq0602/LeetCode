package offer.Meituan;

import java.util.Scanner;

public class m5 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while(cin.hasNextInt()) {
            int T = cin.nextInt();
            String initial = "MeiTuan";
            while (T-- > 0){
                int question = cin.nextInt();
                String s1 = getNewString(initial);
                while (question > s1.length()){
                    s1 = getNewString(s1);
                }
                long index = cin.nextLong()-1;
                index = index % s1.length();
                System.out.println(s1.charAt((int) index));
            }
        }
    }

    private static String getNewString(String str){
        StringBuilder builder = new StringBuilder();
        builder.append(str).append(reverse(str)).append("wow");
        return builder.toString();
    }

    private static String reverse(String str){
        int len = str.length();
        if(len == 0){
            return "";
        }
        StringBuilder builder = new StringBuilder();
        for (int i = len-1; i >=0 ; i--) {
            builder.append(str.charAt(i));
        }
        return builder.toString();
    }
}
