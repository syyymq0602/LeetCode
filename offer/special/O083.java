package offer.special;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 剑指 Offer II 083. 没有重复元素集合的全排列
 *
 * 给定一个不含重复数字的整数数组 nums ，返回其 所有可能的全排列 。可以 按任意顺序 返回答案
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 */
public class O083 {
    public static void main(String[] args) {
        var ans = permute(new int[]{1,2,3});
        for (var item : ans){
            System.out.println(item.toString());
        }
    }

    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> snap = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            snap.add(nums[i]);
        }
        dfs(ans,snap,nums,0);
        return ans;
    }

    private static void dfs(List<List<Integer>> ans, List<Integer> snap, int[] nums, int pos) {
        if(pos == nums.length){
            ans.add(new ArrayList<>(snap));
            return;
        }
        for (int i = pos; i < nums.length; i++) {
            Collections.swap(snap,i,pos);
            dfs(ans,snap,nums,pos+1);
            Collections.swap(snap,i,pos);
        }
    }
}
