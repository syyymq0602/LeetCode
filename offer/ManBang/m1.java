package offer.ManBang;

import java.util.Scanner;

public class m1 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextLine()){
            String s = cin.nextLine();
            long len = s.length();
            if(s.charAt(0) != '1' || len == 1){
                System.out.println(-1);
                continue;
            }
            boolean flag = true;
            int count = 0;
            for (int i = 1; i < len; i++) {
                if(s.charAt(i) != '3'){
                    flag = false;
                    break;
                }
                count++;
            }
            if(flag){
                System.out.println(count);
            }else {
                System.out.println(-1);
            }
        }
    }
}
