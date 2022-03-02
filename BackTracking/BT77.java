package BackTracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 77. 组合
 *
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案。
 *
 * 1 <= n <= 20
 * 1 <= k <= n
 */
public class BT77 {
    public static void main(String[] args) {
        var n = 4;
        var k = 2;
        List<List<Integer>> lists = combine(n, k);
        for (var list:lists) {
            var out = "";
            for (var item:list) {
                out += item + " ";
            }
            System.out.println(out);
        }
    }

    private static List<List<Integer>> combine(int n, int k) {
         List<List<Integer>> ans = new ArrayList<>();
         List<Integer> temp = new ArrayList<>();
         dfs(ans,temp,n,k,1);
         return ans;
    }

    private static void dfs(List<List<Integer>> ans, List<Integer> temp,int n, int k,int pos) {
        if(temp.size() == k){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = pos; i <= n; i++) {
            temp.add(i);
            dfs(ans,temp,n,k,i+1);
            temp.remove(temp.size()-1);
        }
    }
}
