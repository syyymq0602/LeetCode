package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 78. 子集
 *
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 */
public class BT78 {
    public static void main(String[] args) {
        var nums = new int[]{1,2,3};
        var lists = subsets(nums);
        for (var list:lists) {
            var out = "";
            for (var item:list) {
                out += item + " ";
            }
            System.out.println(out);
        }
        System.out.println("============");
        System.out.println(lists.size());
    }

    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        dfs2(ans,temp,nums,0);
//        ans.add(new ArrayList<>());
        return ans;
    }

    private static void dfs(List<List<Integer>> ans, List<Integer> temp, int[] nums, int pos) {
        if(pos == nums.length){
            return;
        }
        for (int i = pos; i < nums.length; i++) {
            temp.add(nums[i]);
            ans.add(new ArrayList<>(temp));
            dfs(ans,temp,nums,i+1);
            temp.remove(temp.size()-1);
        }
    }

    private static void dfs2(List<List<Integer>> ans, List<Integer> temp, int[] nums, int pos) {
        if(pos == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[pos]);
        dfs2(ans,temp,nums,pos+1);
        temp.remove(temp.size()-1);
        dfs2(ans,temp,nums,pos+1);
    }
}
