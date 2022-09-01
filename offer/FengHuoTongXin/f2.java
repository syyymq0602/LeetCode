package offer.FengHuoTongXin;

import java.util.Scanner;

public class f2 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()) {
            int n = cin.nextInt();
            int m = cin.nextInt();
            int k = cin.nextInt();
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = gcd(i + 1, j + 1);
                }
            }
            long sum = 0;
            for (int i = 0; i <= n - k; i++) {
                for (int j = 0; j <= m - k; j++) {
                    sum += getSum(matrix,i,j,i+k-1,j+k-1);
                }
            }
            System.out.println(sum);
        }
    }

    private static int getSum(int[][] matrix, int startX, int startY, int endX, int endY) {
        int sum = 0;
        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        int p = a % b;
        return gcd(b, p);
    }
}

