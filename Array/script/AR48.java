package Array.script;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 48. 旋转图像
 *
 * 给定一个 n×n 的二维矩阵matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 20
 * -1000 <= matrix[i][j] <= 1000
 */
public class AR48 {
    public static void main(String[] args) {
        var matrix = new int[][]{
                {5,1,9,11},{2,4,8,10},
                {13,3,6,7},{15,14,12,16}
        };
        rotate(matrix);
        for (var item:matrix){
            System.out.println(Arrays.toString(item));
        }
    }

    private static void rotate(int[][] matrix) {
        int n = matrix.length;
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < n ; j++) {
            for (int i = n - 1; i >= 0 ; i--) {
                list.add(matrix[i][j]);
            }
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            matrix[i / n][i % n] = list.get(i);
        }
    }
}
