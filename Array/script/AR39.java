package Array.script;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. 组合总和
 *
 * 给你一个 无重复元素 的整数数组candidates 和一个目标整数target，找出candidates中可以使数字和为目标数target 的 所有不同组合 ，
 * 并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 *
 * 对于给定的输入，保证和为target 的不同组合数少于 150 个。
 *
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都 互不相同
 * 1 <= target <= 500
 *
 * 回溯
 *
 */
public class AR39 {
    public static void main(String[] args) {
        var candidates = new int[]{2,3,6,7};
        var target = 7;
        System.out.println(combinationSum(candidates,target).size());
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        dfs(candidates,target,ans,combine,0);
        return ans;
    }

    private static void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int i) {
        if(i == candidates.length){
            return;
        }
        if(target == 0){
            ans.add(new ArrayList<>(combine));
            return;
        }
        // 直接跳过
        dfs(candidates,target,ans,combine,i+1);
        // 选择当前
        if(target - candidates[i] >=0){
            combine.add(candidates[i]);
            dfs(candidates,target-candidates[i],ans,combine,i);
            combine.remove(combine.size()-1);
        }
    }
}
