package DP.scripts;

/**
 * 221. 最大正方形
 *
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 300
 * matrix[i][j] 为 '0' 或 '1'
 */
public class DP221 {
    public static void main(String[] args) {
        var matrix = new char[][]{
            new char[]{'1','0','1','0','0'},
            new char[]{'1','0','1','1','1'},
            new char[]{'1','1','1','1','1'},
            new char[]{'1','0','0','1','0'}
        };
        System.out.println(maximalSquare(matrix));
    }

    private static int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        int rows = matrix.length, columns = matrix[0].length;
        int[][] dp = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }else {
                    dp[i][j] = 0;
                }
            }
        }
        return maxSide * maxSide;
    }
}
