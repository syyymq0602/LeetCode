package BackTracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 46. 全排列
 *
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 */
public class BT46 {
    public static void main(String[] args) {
        var nums = new int[]{1,2,3};
        System.out.println(permute(nums).size());
    }

    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        for (int num : nums) {
            one.add(num);
        }
        dfs(ans,one,nums.length,0);
        return ans;
    }

    private static void dfs(List<List<Integer>> ans, List<Integer> one, int n, int i) {
        if(i == n){
            ans.add(new ArrayList<>(one));
        }
        for (int j = i; j < n; j++) {
            Collections.swap(one,i,j);
            dfs(ans,one,n,i+1);
            Collections.swap(one,i,j);
        }
    }
}
