package Array.script;

/**
 * 240. 搜索二维矩阵 II
 * <p>
 * 编写一个高效的算法来搜索mxn矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= n, m <= 300
 * -10e9<= matrix[i][j] <= 10e9
 * 每行的所有元素从左到右升序排列
 * 每列的所有元素从上到下升序排列
 * -10e9<= target <= 10e9
 */
public class AR240 {
    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{
                {1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}
        }, 5));
    }

    private static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean res = false;
        if (target < matrix[0][0] || target > matrix[n - 1][m - 1]) {
            return res;
        }
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] > target) {
                break;
            }
            if (matrix[i][m - 1] < target) {
                continue;
            }
            int left = 0, right = m - 1;
            while (left <= right) {
                int mid = (right - left) / 2 + left;
                if (matrix[i][mid] == target) {
                    return true;
                } else if (matrix[i][mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return res;
    }
}
