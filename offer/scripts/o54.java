package offer.scripts;

import BT.scripts.TreeNode;
import BT.scripts.TreeNodeUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 *
 * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
 *
 * 1 ≤ k ≤ 二叉搜索树元素个数
 */
public class o54 {
    public static void main(String[] args) {
        var node = TreeNodeUtils.generateByList(Arrays.asList(5,3,6,2,4,null,null,1));
        System.out.println(kthLargest(node,3));
    }

    static int ans;

    private static int kthLargest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        dfs(root,k,list);
        return ans;
    }

    private static void dfs(TreeNode root,int k,List<Integer> temp) {
        if(root == null){
            return;
        }
        dfs(root.right,k,temp);
        if(temp.size() == k-1){
            ans = root.val;
        }
        temp.add(root.val);
        dfs(root.left,k,temp);
    }
}
