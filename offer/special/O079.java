package offer.special;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer II 079. 所有子集
 *
 * 给定一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 */
public class O079 {
    public static void main(String[] args) {
        var ans = subsets(new int[]{1,2,3});
        for (var item : ans){
            System.out.println(item.toString());
        }
    }

    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(nums,ans,temp,0);
        return ans;
    }

    private static void dfs(int[] nums, List<List<Integer>> ans, List<Integer> temp, int index) {
        if(index == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[index]);
        dfs(nums,ans,temp,index+1);
        temp.remove(temp.size()-1);
        dfs(nums,ans,temp,index+1);
    }
}
