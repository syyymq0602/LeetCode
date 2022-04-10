package offer.scripts;

/**
 * 剑指 Offer 47. 礼物的最大价值
 *
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 *
 * 0 < grid.length <= 200
 * 0 < grid[0].length <= 200
 */
public class o47 {
    public static void main(String[] args) {
        var grid = new int[][]{
                {1,3,1},{1,5,1},{4,2,1}
        };
        System.out.println(maxValue(grid));
    }

    private static int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 1; i < m; i++) {
            grid[i][0] = grid[i-1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            grid[0][i] = grid[0][i-1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] = Math.max(grid[i-1][j],grid[i][j-1]) + grid[i][j];
            }
        }
        return grid[m-1][n-1];
    }
}
