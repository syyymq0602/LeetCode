package offer.TuHu;

import BT.scripts.TreeNode;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class t1 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()){
            int n = cin.nextInt();
        }
    }

    private static int ans;

    public static int numColor(TreeNode root) {
        // write code here
        ans = 0;
        Set<Integer> set = new HashSet<>();
        dfs(root,set);
        return ans;
    }

    public static void dfs(TreeNode node,Set<Integer> set){
        if(node == null){
            return;
        }
        if(!set.contains(node.val)){
            ans++;
            set.add(node.val);
        }
        dfs(node.left,set);
        dfs(node.right,set);
    }
}
