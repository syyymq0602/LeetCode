package offer.ShenCe;

import java.util.*;

public class s1 {
    public static void main(String[] args) {

        StringBuilder b =new StringBuilder();
        b.reverse();
        b.append('1');
        b.deleteCharAt(0);
        b.toString();
        Queue<Integer> q= new ArrayDeque<>();
        q.offer(1);
        q.poll();

        Scanner cin = new Scanner(System.in);
        while(cin.hasNextInt()) {
            int n = cin.nextInt();
            int[][] er = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    er[i][j] = cin.nextInt();
                }
            }
            List<List<Integer>> list = new ArrayList<>();
            for (int count = 0; count < 2 * n - 1; count++) {
                List<Integer> temp = new ArrayList<>();
                for (int x = 0; x < n; x++) {
                    int y = count - x;
                    if(y >= 0 && y < n){
                        temp.add(er[x][y]);
                    }
                }
                list.add(temp);
            }
            List<Integer> t = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                // 反序
                if(i%2 == 0){
                    for (int j = list.get(i).size() -1; j >=0; j--) {
                        System.out.print(list.get(i).get(j) + " ");
                    }
                }else {
                    for (int j = 0; j < list.get(i).size(); j++) {
                        System.out.print(list.get(i).get(j) + " ");
                    }
                }
            }
        }
    }
}
