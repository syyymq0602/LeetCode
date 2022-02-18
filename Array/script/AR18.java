package Array.script;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 *
 * 给你一个由 n 个整数组成的数组nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组[nums[a], nums[b], nums[c], nums[d]]（若两个四元组元素一一对应，则认为两个四元组重复）：
 *
 * 0 <= a, b, c, d< n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 *
 * 1 <= nums.length <= 200
 * -10e9 <= nums[i] <= 10e9
 * -10e9 <= target <= 10e9
 */
public class AR18 {
    public static void main(String[] args) {
        var nums = new int[]{2,2,2,2,2};
        var target = 8;
        System.out.println(fourSum(nums,target));
    }

    private static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        if(n<4){
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < n-3; i++) {
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            if((long)nums[i]+nums[i+1]+nums[i+2]+nums[i+3] > target){
                break;
            }
            if((long)nums[i] + nums[n-3] + nums[n-2] + nums[n-1] < target){
                continue;
            }
            for (int j = i+1; j < n-2 ; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if ((long)nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if ((long)nums[i] + nums[j] + nums[n - 2] + nums[n - 1] < target) {
                    continue;
                }
                int left = j+1;
                int right = n-1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
