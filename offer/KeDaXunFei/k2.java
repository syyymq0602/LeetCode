package offer.KeDaXunFei;

import java.util.Scanner;

public class k2 {

    private static int ans;
    private static int[][] dirs = new int[][]{
            {1,0},{-1,0},{0,1},{0,-1}
    };
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()) {
            int n = cin.nextInt();
            int m = cin.nextInt();
            int[][] p_old = new int[n][m];
            int[][] p_new = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    p_old[i][j] = cin.nextInt();
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    p_new[i][j] = cin.nextInt();
                }
            }
            ans = 0;
            boolean[][] visited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(p_old[i][j] == p_new[i][j] && !visited[i][j]){
                        int temp = dfs(p_old,p_new,visited,i,j);
                        ans = Math.max(ans,temp);
                    }
                }
            }
            System.out.println(ans);
        }
    }

    private static int dfs(int[][] p_old, int[][] p_new, boolean[][] visited, int x, int y) {
        if(p_old[x][y] != p_new[x][y]){
            return 0;
        }
        int count = 1;
        visited[x][y] = true;
        for (int[] dir : dirs){
            int newX = x + dir[0];
            int newY = y + dir[1];
            if(newX >= 0 && newX < p_old.length && newY >= 0 && newY < p_old[0].length){
                if(!visited[newX][newY]){
                    count += dfs(p_old,p_new,visited,newX,newY);
                }
            }
        }
        return count;
    }
}
