package offer.ZhaoShang;

import java.util.Scanner;

public class z1 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextLine()){
            int n = Integer.parseInt(cin.nextLine());
            String s = cin.nextLine();
            int len = s.length();
            int index = 0;
            StringBuilder builder = new StringBuilder();
            while (index < len){
                if(index % (n+1) != 0){
                    builder.append(s.charAt(index));
                }
                index++;
            }
            System.out.println(builder.toString());
        }
    }
}
