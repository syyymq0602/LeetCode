package offer.special;

import java.util.Arrays;

/**
 * 剑指 Offer II 073. 狒狒吃香蕉
 *
 * 狒狒喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
 * 狒狒可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，
 * 她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉，下一个小时才会开始吃另一堆的香蕉。
 * 狒狒喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）
 *
 * 1 <= piles.length <= 10e4
 * piles.length <= h <= 10e9
 * 1 <= piles[i] <= 10e9
 */
public class O073 {
    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{30,11,23,4,20},6));
    }

    private static int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int n = piles.length;
        int low = 1, high = piles[n-1];
        while (low < high){
            int mid = low + (high - low) /2;
            if(!possible(piles,h,mid)){
                low = mid + 1;
            }else {
                high = mid;
            }
        }
        return low;
    }

    public static boolean possible(int[] piles, int H, int K) {
        int time = 0;
        for (int p: piles)
            time += (p-1) / K + 1;
        return time <= H;
    }
}
