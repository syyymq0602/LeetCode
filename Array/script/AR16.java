package Array.script;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 *
 * 给你一个长度为 n 的整数数组nums和 一个目标值target。请你从 nums 中选出三个整数，使它们的和与target最接近。
 *
 * 返回这三个数的和。
 *
 * 假定每组输入只存在恰好一个解。
 *
 * 3 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * -104 <= target <= 104
 */
public class AR16 {
    public static void main(String[] args) {
        var nums = new int[]{-3,-2,-5,3,-4};
        var target = -1;
        System.out.println(threeSumClosest(nums,target));
    }

    private static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = (int)Math.exp(6.0);
        int n = nums.length;
        for (int i = 0; i < n-2 ; i++) {
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i+1;
            int right = n-1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == target){
                    return target;
                }
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res= sum;
                }
                if(sum < target){
                    while (left != n-1 && nums[left] == nums[left+1]){
                        left++;
                    }
                    left++;
                }else {
                    while (right > i && nums[right] == nums[right-1]){
                        right--;
                    }
                    right--;
                }
            }
        }
        return res;
    }
}
