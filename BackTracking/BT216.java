package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. 组合总和 III
 *
 * 找出所有相加之和为n 的k个数的组合，且满足下列条件：
 *
 * 只使用数字1到9
 * 每个数字最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 *
 * 2 <= k <= 9
 * 1 <= n <= 60
 */
public class BT216 {
    public static void main(String[] args) {
        var k = 2;
        var n = 9;
        List<List<Integer>> lists = combinationSum3(k, n);
        for (var items:lists) {
            var out = "";
            for (var item:items) {
                out += item + " ";
            }
            System.out.println(out);
        }
    }

    private static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += i;
        }
        if(n<sum){
            return ans;
        }
        List<Integer> temp = new ArrayList<>();
        int res = n;
        dfs2(ans,temp,k,res,1);
        return ans;
    }

    private static void dfs(List<List<Integer>> ans, List<Integer> temp, int k, int sum,int count) {
        if(sum == 0 && temp.size() == k){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(sum<0){
            return;
        }
        for (int i = count; i <= 9; i++) {
            temp.add(i);
            sum = sum-i;
            dfs(ans,temp,k,sum,i+1);
            temp.remove(temp.size()-1);
            sum = sum+i;
        }
    }

    private static void dfs2(List<List<Integer>> ans, List<Integer> temp, int k, int sum,int count) {
        if(sum == 0 && temp.size() == k){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(sum<0 || count ==10){
            return;
        }
        temp.add(count);
        sum = sum -count;
        dfs2(ans,temp,k,sum,count+1);
        temp.remove(temp.size()-1);
        sum = sum + count;
        dfs2(ans,temp,k,sum,count+1);
    }
}

