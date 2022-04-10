package offer.scripts;

/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * <p>
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * <p>
 * 1 <= 数组长度 <= 10000
 */
public class o53_2 {
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{1}));
    }

    private static int missingNumber(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int m = (left + right) / 2;
            if (nums[m] == m) left = m + 1;
            else right = m - 1;
        }
        return left;
    }
}
