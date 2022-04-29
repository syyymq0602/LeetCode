package offer.special;

/**
 * 剑指 Offer II 068. 查找插入位置
 *
 * 给定一个排序的整数数组 nums和一个整数目标值 target ，请在数组中找到target，并返回其下标。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法
 *
 * 1 <= nums.length <= 10e4
 * -10e4 <= nums[i] <= 10e4
 * nums 为无重复元素的升序排列数组
 * -10e4 <= target <= 10e4
 */
public class O068 {
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,2,4,5,7},6));
    }

    private static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        if(target < nums[0]){
            return 0;
        }
        if(target > nums[n-1]){
            return n;
        }
        int left = 0;
        int right = n -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return left;
    }
}
