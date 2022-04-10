package offer.scripts;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 *
 * 统计一个数字在排序数组中出现的次数。
 *
 * 0 <= nums.length <= 105
 * -109<= nums[i]<= 109
 * nums是一个非递减数组
 * -109<= target<= 109
 *
 */
public class o53 {
    public static void main(String[] args) {
        var nums = new int[]{1,2,2};
        System.out.println(search(nums,2));
    }

    private static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int res = 0;
        while (left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] > target){
                right = mid-1;
            }else if(nums[mid] < target){
                left = mid+1;
            }else {
                left = right = mid;
                res++;
                while (left > 0 && nums[left-1] == nums[left]){
                    left--;
                    res++;
                }
                while (right < nums.length-1 && nums[right+1] == nums[right]){
                    right++;
                    res++;
                }
                break;
            }
        }
        return res;
    }
}
