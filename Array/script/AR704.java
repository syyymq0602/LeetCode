package Array.script;

/**
 * 704. 二分查找
 *
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * 你可以假设 nums 中的所有元素是不重复的。
 * n 将在 [1, 10000]之间。
 * nums 的每个元素都将在 [-9999, 9999]之间
 */
public class AR704 {
    public static void main(String[] args) {
        var nums = new int[]{-1,0,3,5,9,12};
        var target = 5;
        System.out.println(search(nums,target));
    }

    private static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int res = -1;
        while (left<=right){
            int mid = (left+right)/2;
            if(target < nums[mid]){
                right = mid-1;
            }else if(target > nums[mid]){
                left = mid+1;
            }else {
                res = mid;
                break;
            }
        }
        return res;
    }
}
