package offer.special;

/**
 * 剑指 Offer II 069. 山峰数组的顶部
 *
 * 符合下列属性的数组 arr 称为 山峰数组（山脉数组） ：
 * arr.length >= 3
 * 存在 i（0 < i< arr.length - 1）使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * 给定由整数组成的山峰数组 arr ，返回任何满足
 * arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i，即山峰顶部
 *
 * 3 <= arr.length <= 10e4
 * 0 <= arr[i] <= 10e6
 * 题目数据保证 arr 是一个山脉数组
 */
public class O069 {
    public static void main(String[] args) {
        System.out.println(peakIndexInMountainArray(new int[]{3,5,3,2,0}));
    }

    private static int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int left = 1, right = n - 2, ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid + 1]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}

