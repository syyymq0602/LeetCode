package offer.special;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 093. 最长斐波那契数列
 *
 * 如果序列X_1, X_2, ..., X_n满足下列条件，就说它是斐波那契式的：
 * n >= 3
 * 对于所有i + 2 <= n，都有X_i + X_{i+1} = X_{i+2}
 * 给定一个严格递增的正整数数组形成序列 arr，找到 arr 中最长的斐波那契式的子序列的长度。如果一个不存在，返回0 。
 * （回想一下，子序列是从原序列 arr 中派生出来的，它从 arr 中删掉任意数量的元素（也可以不删），
 * 而不改变其余元素的顺序。例如，[3, 5, 8]是[3, 4, 5, 6, 7, 8]的一个子序列
 *
 * 3 <= arr.length <= 1000
 * 1 <= arr[i] < arr[i + 1] <= 10^9
 */
public class O093 {
    public static void main(String[] args) {
        System.out.println(lenLongestFibSubseq(new int[]{1,2,3,4,5,6,7,8}));
    }

    private static int lenLongestFibSubseq(int[] arr) {
        int N = arr.length;
        Map<Integer, Integer> index = new HashMap();
        for (int i = 0; i < N; ++i){
            index.put(arr[i], i);
        }

        Map<Integer, Integer> longest = new HashMap();
        int ans = 0;

        for (int k = 0; k < N; ++k)
            for (int j = 0; j < k; ++j) {
                int i = index.getOrDefault(arr[k] - arr[j], -1);
                if (i >= 0 && i < j) {
                    // Encoding tuple (i, j) as integer (i * N + j)
                    int cand = longest.getOrDefault(i * N + j, 2) + 1;
                    longest.put(j * N + k, cand);
                    ans = Math.max(ans, cand);
                }
            }

        return ans > 2 ? ans : 0;
    }
}
