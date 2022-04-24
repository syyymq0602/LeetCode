package offer.special;

import java.util.Arrays;

/**
 * 剑指 Offer II 003. 前 n 个数字二进制中 1 的个数
 * <p>
 * 给定一个非负整数 n ，请计算 0 到 n 之间的每个数字的二进制表示中 1 的个数，并输出一个数组
 * <p>
 * 0 <= n <= 10e5
 */
public class O003 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(5)));
    }

    private static int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            ans[i] = getBits(i);
        }
        return ans;
    }

    private static int getBits(int i) {
        int index = 0;
        while (i > 0){
            i = i & (i-1);
            index++;
        }
        return index;
    }
}
