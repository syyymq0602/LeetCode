package DP.scripts;

/**
 * 63. 不同路径 II
 *
 * 一个机器人位于一个m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * m ==obstacleGrid.length
 * n ==obstacleGrid[i].length
 * 1 <= m, n <= 100
 * obstacleGrid[i][j] 为 0 或 1
 */
public class DP63 {
    public static void main(String[] args) {
        var obstacleGrid = new int[][]{
                new int[]{0,0,1},
                new int[]{0,1,0},
                new int[]{0,0,0}
        };
        System.out.println(uniquePathsWithObstacles1(obstacleGrid));
    }

    private static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1] == 1){
            return 0;
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            if(obstacleGrid[i][0] == 1){
                break;
            }
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            if(obstacleGrid[0][i] == 1){
                break;
            }
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(obstacleGrid[i-1][j]==1){
                    dp[i-1][j] = 0;
                }
                if(obstacleGrid[i][j-1]==1){
                    dp[i][j-1] = 0;
                }
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    // 动态数组
    private static int uniquePathsWithObstacles1(int[][] obstacleGrid){
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[0] = obstacleGrid[0][0] == 0?1:0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(obstacleGrid[i][j] == 1){
                    dp[j] = 0;
                    continue;
                }
                if(j-1>=0 && obstacleGrid[i][j]==0){
                    dp[j] += dp[j-1];
                }
            }
        }
        return dp[n-1];
    }
}
