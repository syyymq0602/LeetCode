package Array.script;

import java.util.Arrays;

/**
 * 1460. 通过翻转子数组使两个数组相等
 *
 * 给你两个长度相同的整数数组target和arr。每一步中，你可以选择arr的任意 非空子数组并将它翻转。你可以执行此过程任意次。
 * 如果你能让 arr变得与 target相同，返回 True；否则，返回 False 。
 *
 * target.length == arr.length
 * 1 <= target.length <= 1000
 * 1 <= target[i] <= 1000
 * 1 <= arr[i] <= 1000
 */
public class AR1460 {
    public static void main(String[] args) {
        System.out.println(canBeEqual(new int[]{1,2,3,4},new int[]{2,4,1,3}));
    }

    private static boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        return Arrays.equals(target,arr);
    }
}
