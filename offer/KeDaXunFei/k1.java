package offer.KeDaXunFei;

import java.util.Scanner;

public class k1 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()) {
            int M = cin.nextInt();
            int N = cin.nextInt();
            int K = cin.nextInt();
            int L = cin.nextInt();
            int[][] I_nums = new int[M][N];
            int[][] K_nums = new int[K][L];
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    I_nums[i][j] = cin.nextInt();
                }
            }
            for (int i = 0; i < K; i++) {
                for (int j = 0; j < L; j++) {
                    K_nums[i][j] = cin.nextInt();
                }
            }
            int[][] ans = new int[M][N];
            int x_center = K / 2;
            int y_center = L / 2;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    int temp = 0;
                    for (int k = 0; k < K; k++) {
                        for (int l = 0; l < L; l++) {
                            int delta_x = k - x_center;
                            int delta_y = l - y_center;
                            int newX = i + delta_x;
                            int newY = j + delta_y;
                            if(newX >= 0 && newX < M && newY >= 0 && newY < N){
                                temp += I_nums[newX][newY] * K_nums[k][l];
                            }
                        }
                    }
                    if(temp < 0){
                        ans[i][j] = 0;
                    } else if (temp > 255) {
                        ans[i][j] = 255;
                    }else {
                        ans[i][j] = temp;
                    }
                }
            }
            for (int i = 0; i < M; i++) {
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < N; j++) {
                    builder.append(ans[i][j]).append(" ");
                }
                System.out.println(builder.toString().trim());
            }
        }
    }
}
