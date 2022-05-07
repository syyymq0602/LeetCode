package offer.special;

import java.util.Arrays;

/**
 * 剑指 Offer II 075. 数组相对排序
 *
 * 给定两个数组，arr1 和arr2，
 * arr2中的元素各不相同
 * arr2 中的每个元素都出现在arr1中
 * 对 arr1中的元素进行排序，使 arr1 中项的相对顺序和arr2中的相对顺序相同。未在arr2中出现过的元素需要按照升序放在arr1的末尾
 *
 * 1 <= arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2中的元素arr2[i]各不相同
 * arr2 中的每个元素arr2[i]都出现在arr1中
 */
public class O075 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(relativeSortArray(
                new int[]{2,3,1,3,2,4,6,7,9,2,19},new int[]{2,1,4,3,9,6})));
    }

    private static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int max = 0;
        for (int i : arr1) {
            max = Math.max(max, i);
        }
        int[] cnt = new int[max + 1];
        // 计数
        for (int i : arr1) {
            ++cnt[i];
        }
        int[] ans = new int[arr1.length];
        int idx = 0;
        // 按arr2排序
        for (int i : arr2) {
            while (cnt[i]-- > 0) {
                ans[idx++] = i;
            }
        }
        // 自然排序
        for (int i = 0; i < max + 1; i++) {
            while (cnt[i]-- > 0) {
                ans[idx++] = i;
            }
        }
        return ans;
    }
}
