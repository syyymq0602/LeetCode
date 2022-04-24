package offer.special;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剑指 Offer II 007. 数组中和为 0 的三个数
 *
 * 给定一个包含 n 个整数的数组nums，判断nums中是否存在三个元素a ，b ，c ，使得a + b + c = 0 ？
 * 请找出所有和为 0 且不重复的三元组
 *
 * 0 <= nums.length <= 3000
 * -10e5 <= nums[i] <= 10e5
 */
public class O007 {
    public static void main(String[] args) {
        var res = threeSum(new int[]{-1,0,1,2,-1,-4});
        for (var item:res) {
            System.out.println(item.toString());
        }
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        if(n < 3 || nums[0] > 0){
            return ans;
        }
        for (int i = 0; i < n; i++) {
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i+1,right = n-1;
            while (left < right){
                if(nums[left] + nums[right] + nums[i] < 0){
                    left++;
                }else if(nums[left] + nums[right] + nums[i] > 0){
                    right--;
                }else {
                    ans.add(Arrays.asList(nums[left],nums[right],nums[i]));
                    while (left != n-1 && nums[left] == nums[left+1]){
                        left++;
                    }
                    while (right != i+1 && nums[right] == nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }
        return ans;
    }
}
