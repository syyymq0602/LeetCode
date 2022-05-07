package offer.special;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer II 081. 允许重复选择元素的组合
 *
 * 给定一个无重复元素的正整数数组candidates和一个正整数target，找出candidates中所有可以使数字和为目标数target的唯一组合。
 * candidates中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为target 的唯一组合数少于 150 个
 *
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 */
public class O081 {
    public static void main(String[] args) {
        var ans = combinationSum(new int[]{2,3,5},8);
        for (var item : ans){
            System.out.println(item.toString());
        }
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(ans,temp,0,candidates,target);
        return ans;
    }

    private static void dfs(List<List<Integer>> ans, List<Integer> temp, int pos, int[] candidates, int target) {
        if(pos == candidates.length || target < 0){
            return;
        }
        if(target == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(target - candidates[pos] >= 0){
            temp.add(candidates[pos]);
            dfs(ans,temp,pos,candidates,target-candidates[pos]);
            temp.remove(temp.size()-1);
        }
        dfs(ans,temp,pos+1,candidates,target);
    }
}
