package Array.script;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 *
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 0 <= nums.length <= 3000
 * -10e5 <= nums[i] <= 10e5
 */
public class AR15 {
    public static void main(String[] args) {
        var nums = new int[]{0,0,0};
        System.out.println(threeSum(nums));
        var res = "";
//        for(var items : threeSum(nums)){
//            for (var item: items) {
//                res += item + " ";
//            }
//            System.out.println(res);
//            res = "";
//        }
    }
    private static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        if(n <3 || nums[0] > 0){
            return res;
        }
        for (int i = 0; i < n-2 ; i++) {
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i+1;
            int right = n-1;
            while (left < right){
                if(nums[left] + nums[right] < -nums[i]){
                    left++;
                }else if(nums[left] + nums[right] > -nums[i]){
                    right--;
                }else {
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while (left != n-1 && nums[left] == nums[left+1] ){
                        left++;
                    }
                    while (right>i && nums[right] == nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }
        return res;
    }
}
