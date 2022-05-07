package offer.special;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer II 080. 含有 k 个元素的组合
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合
 *
 * 1 <= n <= 20
 * 1 <= k <= n
 */
public class O080 {
    public static void main(String[] args) {
        var ans = combine(4,2);
        for (var item : ans){
            System.out.println(item.toString());
        }
    }

    private static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(ans,temp,n,k,1);
        return ans;
    }

    private static void dfs(List<List<Integer>> ans, List<Integer> temp, int n, int k, int index) {
        // 剪枝，可以减少不必要的递归
        if(temp.size() + (n - index + 1) < k){
            return;
        }
        if(temp.size() == k){
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(index);
        dfs(ans,temp,n,k,index+1);
        temp.remove(temp.size()-1);
        dfs(ans,temp,n,k,index+1);
    }
}
