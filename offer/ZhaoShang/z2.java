package offer.ZhaoShang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.ThreadPoolExecutor;

public class z2 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextLine()){
            int total = Integer.parseInt(cin.nextLine());
            String[][] infos = new String[total][];
            for (int i = 0; i < total; i++) {
                String info = cin.nextLine();
                String[] is = info.split(" ");
                int count = 0;
                int index = 0;
                for (int j = 1; j < is.length; j++) {
                    if(Objects.equals(is[j], "?")){
                        count++;
                        index = j;
                    }
                }
                if(count == 1){
                    if(index == is.length -1){
                        is[index] = (Integer.parseInt(is[1]) + Integer.parseInt(is[2])
                                + Integer.parseInt(is[3])) + "";
                    }else {
                        int sum = Integer.parseInt(is[is.length-1]);
                        for (int j = 1; j < is.length - 1; j++) {
                            if(j == index){
                                continue;
                            }
                            sum = sum - Integer.parseInt(is[j]);
                        }
                        is[index] = sum + "";
                    }
                }
                infos[i] = is;
            }
            for (int i = 0; i < total; i++) {
                for (int j = i; j > 0 ; j--) {
                    String[] s1 = infos[j];
                    String[] s2 = infos[j-1];
                    int score1 = Objects.equals(s1[s1.length - 1], "?") ? -1:Integer.parseInt(s1[s1.length-1]);
                    int score2 = Objects.equals(s2[s2.length - 1], "?") ? -1:Integer.parseInt(s2[s2.length-1]);
                    if(score2 < score1){
                        swap(infos,j,j-1);
                    } else if (score1 == score2) {
                        String ss1 = s1[0];
                        String ss2 = s2[0];
                        if(Objects.equals(ss2, "?") && !Objects.equals(ss1, "?")){
                            swap(infos,j,j-1);
                        } else if (!Objects.equals(ss2, "?") && !Objects.equals(ss1, "?")) {
                            String[] temp = new String[]{ss2,ss1};
                            Arrays.sort(temp);
                            if(!Objects.equals(temp[0], ss2)){
                                swap(infos,j,j-1);
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < total; i++) {
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < infos[i].length; j++) {
                    builder.append(infos[i][j]).append(" ");
                }
                System.out.println(builder.toString().trim());
            }
            System.out.println();
        }
    }

    private static void swap(String[][] infos,int start,int end){
        String[] temp = infos[start];
        infos[start] = infos[end];
        infos[end] = temp;
    }

}
