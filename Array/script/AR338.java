package Array.script;

import java.util.Arrays;

/**
 * 338. 比特位计数
 *
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 *
 * 0 <= n <= 10e5
 */
public class AR338 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits2(5)));
    }

    private static int[] countBits(int n) {
        int[] res = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int num = i;
            int temp = 0;
            while (num != 0){
                num = num & (num -1);
                temp++;
            }
            res[i] = temp;
        }
        return res;
    }

    private static int[] countBits2(int n) {
        int[] bits = new int[n + 1];
        int highBit = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
            bits[i] = bits[i - highBit] + 1;
        }
        return bits;
    }
}
