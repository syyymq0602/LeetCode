package offer.XiaoHongShu;

import java.util.Arrays;
import java.util.Scanner;

public class x3 {
    private static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;
        boolean[] vis = new boolean[n + 1];
        int[][] friends = new int[n + 1][2];
        int[] sum = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            friends[i][0] = i;
        }
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 2; i <= n; i++) {
            int j = sc.nextInt();
            graph[i][j] = 1;
            graph[j][i] = 1;
            friends[i][1]++;
            friends[j][1]++;
            sum[i]++;
            sum[j]++;
        }
        Arrays.sort(friends,(int[] o1, int[] o2) -> o1[1] - o2[1]);
        for (int i = 1; i <= n ; i++) {
            int index = friends[i][0];
            if(!vis[index]){
                vis[index] = true;
                int min = Integer.MAX_VALUE;
                int next = 0;
                for (int j = 1; j <= n; j++) {
                    if (graph[index][j] == 1 && min > sum[j] && !vis[j]){
                        min = sum[j];
                        vis[next] = false;
                        next = j;
                        vis[next] = true;
                    }
                }
                if (next != 0){
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }

    private static void dfs(int[] employee, boolean[] mark,int index) {
        if(index == employee.length){
            return;
        }
        int bh = employee[index];
        if(!mark[index+1] && !mark[bh]){
            ans++;
            mark[index+1] = true;
            mark[bh] = true;
        }
        for (int i = index+1; i < employee.length; i++) {
            if(!mark[i]){
                dfs(employee,mark,i+1);
            }
        }
    }
}
