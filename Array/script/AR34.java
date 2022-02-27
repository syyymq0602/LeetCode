package Array.script;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 *
 */
public class AR34 {
    public static void main(String[] args) {
        var nums = new int[]{0,1};
        var target = 1;
        var out = "";
        for (var item:searchRange(nums,target)) {
            out += item+" ";
        }
        System.out.println(out);
    }

    private static int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] res = new int[]{-1,-1};
        if(n == 0){
            return res;
        }
        int left = 0;
        int right = n-1;
        int mid;
        while (left<=right){
            mid = (left+right)/2;
            if(target < nums[mid]){
                right = mid-1;
            }else if(target>nums[mid]){
                left = mid+1;
            }else {
                left = right = mid;
                while (target == nums[left] && left>0){
                    left--;
                }
                while (target == nums[right] && right<n-1){
                    right++;
                }
                res[0] = (left == 0 && target == nums[0]) ?0:left+1;
                res[1] = (right == n-1&& nums[right] == target)?n-1:right-1;
                return res;
            }
        }
        return res;
    }
}
