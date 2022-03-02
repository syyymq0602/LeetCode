package BackTracking;

import java.util.*;

/**
 * 47. 全排列 II
 *
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 */
public class BT47 {

    private static boolean[] vis;
    public static void main(String[] args) {
        var nums = new int[]{1,1,4,5};
        List<List<Integer>> unique = permuteUnique(nums);
        for (var list:unique) {
            var out = "";
            for (var item:list) {
                out += item + " ";
            }
            System.out.println(out);
        }
    }

    private static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, ans, 0, perm);
        return ans;
    }

    private static void dfs(int[] nums, List<List<Integer>> ans, int idx, List<Integer> perm) {
        if (idx == nums.length) {
            ans.add(new ArrayList<>(perm));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            perm.add(nums[i]);
            vis[i] = true;
            dfs(nums, ans, idx + 1, perm);
            vis[i] = false;
            perm.remove(idx);
        }
    }
}
