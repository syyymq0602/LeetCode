package Array.script;

/**
 * 1351. 统计有序矩阵中的负数
 *
 * 给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。 请你统计并返回 grid 中 负数 的数目
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 100
 * -100 <= grid[i][j] <= 100
 */
public class AR1351 {
    public static void main(String[] args) {
        var grid = new int[][]{
                new int[]{4,3,2,-1},
                new int[]{3,2,1,-1},
                new int[]{1,1,-1,-2},
                new int[]{-1,-1,-2,-3}
        };
        System.out.println(countNegatives(grid));
    }

    private static int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            if(grid[i][n-1] >= 0){
                continue;
            }
            if(grid[i][0] < 0){
                ans+=n;
                continue;
            }
            int left = 0, right = n-1;
            while (left <= right){
                int mid = left + (right - left)/2;
                if(grid[i][mid] < 0 && grid[i][mid-1] >= 0){
                    ans += (n - mid);
                    break;
                } else if(grid[i][mid] >= 0) {
                    left = mid+1;
                }else {
                    right = mid-1;
                }
            }
        }

        return ans;
    }
}
