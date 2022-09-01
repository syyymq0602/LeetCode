package offer.JingDong;

import java.util.Scanner;

public class j1 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextLine()){
            String input = cin.nextLine();
            int n = Integer.parseInt(input.split(" ")[0]);
            int k = Integer.parseInt(input.split(" ")[1]);
            String str = cin.nextLine();
            char[] chars = str.toCharArray();
            String s1 = str.substring(0,k);
            String s2 = str.substring(k,n);
            s1 = s1.toUpperCase();
            s2 = s2.toLowerCase();
            int index = 0;
            while (index < s1.length()){
                chars[index] = s1.charAt(index);
                index++;
            }
            while (index < n){
                chars[index] = s2.charAt(index - k);
                index++;
            }
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                builder.append(chars[i]);
            }
            System.out.println(builder.toString());
        }
    }
}
