package Array.script;

/**
 * 1582. 二进制矩阵中的特殊位置
 *
 * 给你一个大小为 rows x cols 的矩阵 mat，其中 mat[i][j] 是 0 或 1，请返回 矩阵mat 中特殊位置的数目 。
 * 特殊位置 定义：如果 mat[i][j] == 1 并且第 i 行和第 j 列中的所有其他元素均为 0（行和列的下标均 从 0 开始 ），则位置 (i, j) 被称为特殊位置。
 *
 * rows == mat.length
 * cols == mat[i].length
 * 1 <= rows, cols <= 100
 * mat[i][j] 是 0 或 1
 */
public class AR1582 {
    public static void main(String[] args) {
        var nums = new int[][]{
                {0,0,0,0,0},
                {1,0,0,0,0},
                {0,1,0,0,0},
                {0,0,1,0,0},
                {0,0,0,1,1}
        };
        System.out.println(numSpecial(nums));

    }

    private static int numSpecial(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(mat[i][j] == 1 && dfs(i,j,rows,cols,mat)){
                    ans++;
                }
            }
        }
        return ans;
    }

    private static boolean dfs(int x, int y, int rows, int cols,int[][] mat) {
        for (int i = 0; i < rows; i++) {
            if (i == x) {
                continue;
            }
            if (mat[i][y] == 1) {
                return false;
            }
        }
        for (int i = 0; i < cols; i++) {
            if (i == y) {
                continue;
            }
            if (mat[x][i] == 1) {
                return false;
            }
        }
        return true;
    }
}
