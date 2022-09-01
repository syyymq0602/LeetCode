package offer.XieCheng;

import java.util.Scanner;

public class x1 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()){
            int n = cin.nextInt();
            while (n -- > 0){
                int num = cin.nextInt();
                if(num % 2 == 0){
                    System.out.println(num);
                    continue;
                }
                String nums = num + "";
                char[] chars = nums.toCharArray();
                boolean flag = false;
                int index = 0;
                for (int i = 0; i < chars.length; i++) {
                    int w = chars[i] - '0';
                    if(w % 2 == 0){
                        index = i;
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    System.out.println(-1);
                }else {
                    char temp = chars[index];
                    chars[index] = chars[chars.length-1];
                    chars[chars.length-1] = temp;
                    StringBuilder builder = new StringBuilder();
                    for (int i = 0; i < chars.length; i++) {
                        builder.append(chars[i]);
                    }
                    System.out.println(builder.toString());
                }
            }
        }
    }
}
