package offer.special;

/**
 * 剑指 Offer II 070. 排序数组中只出现一次的数字
 *
 * 给定一个只包含整数的有序数组 nums ，每个元素都会出现两次，唯有一个数只会出现一次，请找出这个唯一的数字
 *
 * 1 <= nums.length <= 10e5
 * 0 <= nums[i] <= 10e5
 */
public class O070 {
    public static void main(String[] args) {
        System.out.println(singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
    }

    private static int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if(n == 1 || nums[0] != nums[1]){
            return nums[0];
        }
        if(nums[n-1] != nums[n-2]){
            return nums[n-1];
        }
        int ans = -1;
        for (int i = 1; i < n-1; i++) {
            if(nums[i] != nums[i-1] && nums[i] != nums[i+1]){
                ans = nums[i];
                break;
            }
        }
        return ans;
    }
}
