package Array.script;

import java.util.*;

/**
 * 40. 组合总和 II
 *
 * 给定一个候选人编号的集合candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 *
 * candidates中的每个数字在每个组合中只能使用一次。
 *
 * 注意：解集不能包含重复的组合。
 *
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 */
public class AR40 {

    private static Boolean[] dps;
    public static void main(String[] args) {
        var candidates = new int[]{10,1,2,7,6,1,5};
        var target = 8;
        System.out.println(combinationSum2(candidates,target).size());
    }

    private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> paths = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        dps = new Boolean[candidates.length];
        dfs(ans,candidates.length,candidates,target,path,0);
//        backtracking(ans,candidates,target,dps,paths,0);
        return ans;
    }

    private static void dfs(List<List<Integer>> ans, int len, int[] candidates, int target, Deque<Integer> path, int i) {
        if(target == 0){
            ans.add(new ArrayList<>(path));
            return;
        }
        if(i == len){
            return;
        }
        for (int j = i; j < len; j++) {
            if(target<0){
                break;
            }
            if(j > i && candidates[j] == candidates[j-1]){
                continue;
            }

            path.addLast(candidates[j]);
            dfs(ans,len,candidates,target-candidates[j],path,j+1);
            path.removeLast();
        }
    }

    private static void backtracking(List<List<Integer>> ans, int[] candidates, int target, Boolean[] dps, List<Integer> paths, int i){
        if(target == 0){
            ans.add(new ArrayList<>(paths));
            return;
        }
        if(i == candidates.length){
            return;
        }
        for (int j = i; j < candidates.length; j++) {
            if(j>i&&candidates[j]==candidates[j-1]&&!dps[j-1]){
                continue;
            }
            if(target<0){
                break;
            }
            paths.add(candidates[j]);
            target = target - candidates[j];
            dps[j] = true;
            backtracking(ans,candidates,target,dps,paths,i+1);
            dps[j] = false;
            paths.remove(paths.size()-1);
        }
    }
}
