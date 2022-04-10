package offer.scripts;

/**
 * 剑指 Offer 04. 二维数组中的查找
 *
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 *
 * 0 <= n <= 1000
 * 0 <= m <= 1000
 */
public class o04 {
    public static void main(String[] args) {
        var matrix = new int[][]{
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(findNumberIn2DArray(matrix,0));
    }

    private static boolean findNumberIn2DArray(int[][] matrix, int target) {
        int n = matrix.length;
        if(n == 0){
            return false;
        }
        int m = matrix[0].length;
        if(m == 0){
            return false;
        }
        boolean res = false;
        for (int i = 0; i < n; i++) {
            if(matrix[i][m-1] < target){
                continue;
            }
            if(matrix[i][0] > target){
                break;
            }
            int left = 0,right = m-1;
            while (left<=right){
                int mid = left + (right - left)/2;
                if(matrix[i][mid] < target){
                    left = mid+1;
                }else if(matrix[i][mid] > target){
                    right = mid-1;
                }else {
                    res = true;
                    break;
                }
            }
        }
        return res;
    }
}
