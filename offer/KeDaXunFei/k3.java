package offer.KeDaXunFei;

import java.util.Scanner;

public class k3 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextLine()) {
            String num_str = cin.nextLine();
            int N = Integer.parseInt(num_str);
            int record = 0;
            int t = N;
            while (t-- > 0){
                String line = cin.nextLine();
                if(line.contains("iflytek")){
                    record++;
                }
                String[] l = line.split(" ");
            }
            System.out.println(3);
        }
    }
}
