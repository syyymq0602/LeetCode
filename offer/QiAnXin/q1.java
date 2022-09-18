package offer.QiAnXin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class q1 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextLine()){
            String A = cin.nextLine();
            String B = cin.nextLine();
            String[] As = A.split(",");
            String[] Bs = B.split(",");
            int[] pA = new int[As.length];
            int[] pB = new int[Bs.length];
            for (int i = 0; i < As.length; i++) {
                pA[i] = Integer.parseInt(As[i]);
                pB[i] = Integer.parseInt(Bs[i]);
            }
            List<Integer> al = new ArrayList<>();
            List<Integer> bl = new ArrayList<>();
            for (int i = 0; i < As.length; i++) {
                if(pA[i] > pB[i]){
                    bl.add(pB[i]);
                }else {
                    al.add(pA[i]);
                }
            }
            int sum = 0;
            sum += dealA(al);
            sum += dealB(bl);
            System.out.println(sum);
        }
    }

    private static int dealB(List<Integer> list) {
        int count = 0;
        Collections.sort(list);
        int sum = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            count++;
            if(count % 3 == 0){
                continue;
            }
            sum += list.get(i);
        }
        return sum;
    }

    private static int dealA(List<Integer> list) {
        int len = list.size();
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += list.get(i);
        }
        return len >= 3? (int)(sum * 0.6) : sum;
    }
}
