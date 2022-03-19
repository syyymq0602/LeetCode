package NK;

import java.util.Scanner;

/**
 *小美请小团吃回转寿司。转盘上有N盘寿司围成一圈，第1盘与第2盘相邻，第2盘与第3盘相邻，…，
 * 第N-1盘与第N盘相邻，第N盘与第1盘相邻。小团认为第i盘寿司的美味值为A[i]（可能是负值，如果小团讨厌这盘寿司）。
 * 现在，小团要在转盘上选出连续的若干盘寿司，使得这些寿司的美味值之和最大（允许不选任何寿司，此时美味值总和为0）。
 *
 * 第一行输入一个整数T（1<=T<=10），表示数据组数。
 * 每组数据占两行，第一行输入一个整数N（1<=N<=10^5）；
 * 第二行输入N个由空格隔开的整数，表示A[1]到A[N]（-10^4<=A[i]<=10^4）。
 *
 * 每组数据输出占一行，输出一个整数，表示连续若干盘寿司的美味值之和的最大值。
 */
public class NK4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int total = scanner.nextInt();
            while (total-- > 0){
                int num = scanner.nextInt();
                int[] ss = new int[num];
                int sum = 0;
                for (int i = 0; i < num; i++) {
                    ss[i] = scanner.nextInt();
                    sum += ss[i];
                }
                int max = ss[0];
                int min = ss[0];
                int dpMax = ss[0];
                int dpMin = ss[0];
                for(int i = 1; i < num; i++){
                    dpMax = Math.max(dpMax + ss[i], ss[i]);
                    max = Math.max(max, dpMax);
                    dpMin = Math.min(dpMin + ss[i], ss[i]);
                    min = Math.min(min, dpMin);
                }
                System.out.println(Math.max(sum - min, max));
            }
        }
    }
}
