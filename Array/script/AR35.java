package Array.script;

/**
 * 35. 搜索插入位置
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 为无重复元素的升序排列数组
 * -104 <= target <= 104
 */
public class AR35 {
    public static void main(String[] args) {
        var nums = new int[]{1,3,5,6};
        var target = 5;
        System.out.println(searchInsert(nums,target));
    }
    private static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int index = 0;
        while (nums[index]<target){
            if(index == n-1){
                return index+1;
            }
            index++;
        }
        return index;
    }
}
