package offer.special;

/**
 * 剑指 Offer II 013. 二维子矩阵的和
 *
 * 给定一个二维矩阵 matrix，以下类型的多个请求：
 *
 * 计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1,col1) ，右下角为 (row2,col2) 。
 * 实现 NumMatrix 类：
 * NumMatrix(int[][] matrix)给定整数矩阵 matrix 进行初始化
 * int sumRegion(int row1, int col1, int row2, int col2)返回左上角 (row1,col1)、右下角(row2,col2)的子矩阵的元素总和。
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m,n <=200
 * -10e5<= matrix[i][j] <= 10e5
 * 0 <= row1 <= row2 < m
 * 0 <= col1 <= col2 < n
 * 最多调用 10e4 次sumRegion 方法
 */
public class O013 {
    public static void main(String[] args) {
        int[][] sz = new int[][]{
                {3,0,1,4,2},
                {5,6,3,2,1},
                {1,2,0,1,5},
                {4,1,0,1,7},
                {1,0,3,0,5}
        };
        NumMatrix numMatrix = new NumMatrix(sz);
        System.out.println(numMatrix.sumRegion(2,1,4,3));
        System.out.println(numMatrix.sumRegion(1,1,2,2));
        System.out.println(numMatrix.sumRegion(1,2,2,4));
    }

    static class NumMatrix {

        int[][] items;

        public NumMatrix(int[][] matrix) {
            this.items = matrix;
            int m = matrix.length;
            int n = matrix[0].length;
            for (int i = 0; i < m; i++) {
                int sum = 0;
                for (int j = 0; j < n; j++) {
                    sum += this.items[i][j];
                    this.items[i][j] = sum;
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = 0;
            for (int i = row1; i <= row2; i++) {
                if(col1 > 0){
                    sum += this.items[i][col2] - this.items[i][col1-1];
                }else {
                    sum += this.items[i][col2];
                }
            }
            return sum;
        }
    }
}
