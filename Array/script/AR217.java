package Array.script;

import java.util.HashSet;

/**
 * 217. 存在重复元素
 *
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 *
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
public class AR217 {
    public static void main(String[] args) {
        var nums = new int[]{1,2,3,4};
        System.out.println(containsDuplicate(nums));
    }

    private static boolean containsDuplicate(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return false;
        }
        boolean res;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            res = set.add(nums[i]);
            if(!res){
                return true;
            }
        }
        return false;
    }
}
