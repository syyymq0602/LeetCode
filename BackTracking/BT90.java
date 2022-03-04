package BackTracking;

import java.util.*;

/**
 * 90. 子集 II
 *
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * */
public class BT90 {
    public static void main(String[] args) {
        var nums = new int[]{1,2,2};
        List<List<Integer>> lists = subsetsWithDup(nums);
        for (var list:lists) {
            var out = "";
            for (var item:list) {
                out += item + " ";
            }
            System.out.println(out);
        }
        System.out.println(lists.size());
    }

    private static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] loc = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(ans,temp,nums,loc,0);
        ans.add(new ArrayList<>());
        return ans;
    }

    private static void dfs(List<List<Integer>> ans, List<Integer> temp, int[] nums, boolean[] loc, int pos) {
        if(pos == nums.length){
            return;
        }

        for (int i = pos; i < nums.length; i++) {
            if(i>0 && nums[i] == nums[i-1] && !loc[i-1]){
                continue;
            }
            temp.add(nums[i]);
            ans.add(new ArrayList<>(temp));
            loc[i] = true;
            dfs(ans,temp,nums,loc,i+1);
            temp.remove(temp.size()-1);
            loc[i] = false;
        }
    }
}
