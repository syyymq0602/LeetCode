package offer.WangYi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class w2 {
    static int total;
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while(cin.hasNextInt()) {
            int n = cin.nextInt();
            StringBuilder builder;
            List<Integer> list = new ArrayList<>();
            total = 0;
            if(n < 25){
                System.out.println(total);
            }else {
                builder = new StringBuilder("25");
                // 向前延展
                dfsFront(builder,n,list);
                // 向后延展
                List<Integer> copy = new ArrayList<>(list);
                for (Integer item:copy){
                    StringBuilder b = new StringBuilder(item.toString());
                    dfsBack(list,n,b);
                }
                System.out.println(list.size());
            }
        }
    }

    private static void dfsFront(StringBuilder builder, int top,List<Integer> list) {
        if(Integer.parseInt(builder.toString()) > top){
            return;
        }
        if(!builder.toString().startsWith("0")){
            total++;
            list.add(Integer.parseInt(builder.toString()));
        }
        String temp = builder.toString();
        for (int i = 0; i <= 9; i++) {
            if(temp.startsWith("0") && i == 0){
                continue;
            }
            builder = new StringBuilder();
            builder.append(i).append(temp);
            dfsFront(builder,top,list);
            builder.deleteCharAt(0);
        }
    }

    private static void dfsBack(List<Integer> list,int top,StringBuilder builder) {
        if(Integer.parseInt(builder.toString()) > top){
            return;
        }
        for (int i = 0; i <= 9 ; i++) {
            builder.append(i);
            if(Integer.parseInt(builder.toString()) <= top){
                list.add(Integer.parseInt(builder.toString()));
            }
            dfsBack(list,top,builder);
            builder.deleteCharAt(builder.length()-1);
        }
    }
}
