package offer.special;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剑指 Offer II 082. 含有重复元素集合的组合
 *
 * 给定一个可能有重复数字的整数数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * candidates中的每个数字在每个组合中只能使用一次，解集不能包含重复的组合
 *
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 */
public class O082 {
    public static void main(String[] args) {
        var ans = combinationSum2(new int[]{10,1,2,7,6,1,5},8);
        for (var item : ans){
            System.out.println(item.toString());
        }
    }

    private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(ans,temp,candidates,0,target);
        return ans;
    }

    private static void dfs(List<List<Integer>> ans, List<Integer> temp, int[] candidates, int pos, int target) {
        if(target == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(pos == candidates.length){
            return;
        }
        for (int i = pos; i < candidates.length; i++) {
            if(target - candidates[i] < 0){
                break;
            }
            if(i > pos && candidates[i] == candidates[i-1]){
                continue;
            }
            temp.add(candidates[i]);
            dfs(ans,temp,candidates,i+1,target - candidates[i]);
            temp.remove(temp.size()-1);
        }
    }
}
