package offer.special;

import java.util.Arrays;

/**
 * 剑指 Offer II 071. 按权重生成随机数
 *
 * 给定一个正整数数组w ，其中w[i]代表下标 i的权重（下标从 0 开始），
 * 请写一个函数pickIndex，它可以随机地获取下标 i，选取下标 i的概率与w[i]成正比。
 * 例如，对于 w = [1, 3]，挑选下标 0 的概率为 1 / (1 + 3)= 0.25 （即，25%），
 * 而选取下标 1 的概率为 3 / (1 + 3)= 0.75（即，75%）。
 * 也就是说，选取下标 i 的概率为 w[i] / sum(w)
 *
 * 1 <= w.length <= 10000
 * 1 <= w[i] <= 10^5
 * pickIndex 将被调用不超过 10000 次
 */
public class O071 {
    public static void main(String[] args) {
        var solu = new Solution(new int[]{1,3});
        System.out.println(solu.pickIndex());
        System.out.println(solu.pickIndex());
        System.out.println(solu.pickIndex());
        System.out.println(solu.pickIndex());
    }

    private static class Solution {
        int[] pre;
        int sum;
        public Solution(int[] w) {
            pre = new int[w.length];
            pre[0] = w[0];
            for (int i = 1; i < w.length; i++) {
                pre[i] = pre[i-1] + w[i];
            }
            sum = Arrays.stream(w).sum();
        }

        public int pickIndex() {
            int x = (int) (Math.random() * sum) + 1;
            return binarySearch(x);
        }

        private int binarySearch(int x) {
            int low = 0, high = pre.length - 1;
            while (low < high) {
                int mid = (high - low) / 2 + low;
                if (pre[mid] < x) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }
    }
}
