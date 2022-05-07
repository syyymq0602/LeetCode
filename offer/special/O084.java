package offer.special;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剑指 Offer II 084. 含有重复元素集合的全排列
 *
 * 给定一个可包含重复数字的整数集合 nums ，按任意顺序 返回它所有不重复的全排列
 *
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 */
public class O084 {
    public static void main(String[] args) {
        var ans = permuteUnique(new int[]{1,2,1});
        for (var item : ans){
            System.out.println(item.toString());
        }
    }

    private static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> snap = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(ans,snap,nums,0,vis);
        return ans;
    }

    private static void dfs(List<List<Integer>> ans, List<Integer> snap, int[] nums, int pos, boolean[] vis) {
        if(pos == nums.length){
            ans.add(new ArrayList<>(snap));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(vis[i] || (i > 0 && nums[i] == nums[i-1]) && !vis[i-1]){
                continue;
            }
            snap.add(nums[i]);
            vis[i] = true;
            dfs(ans,snap,nums,pos+1, vis);
            vis[i] = false;
            snap.remove(snap.size()-1);
        }
    }
}
