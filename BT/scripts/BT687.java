package BT.scripts;

import java.util.Arrays;

/**
 * 687. 最长同值路径
 *
 * 给定一个二叉树的root，返回最长的路径的长度 ，这个路径中的每个节点具有相同值。
 * 这条路径可以经过也可以不经过根节点。
 * 两个节点之间的路径长度由它们之间的边数表示
 *
 * 树的节点数的范围是 [0, 10e4] 
 * -1000 <= Node.val <= 1000
 * 树的深度将不超过 1000 
 */
public class BT687 {
    public static void main(String[] args) {
        var root = TreeNodeUtils.generateByList(Arrays.asList(1,4,5,4,4,5));
        System.out.println(longestUnivaluePath(root));
    }
    private static int res;

    private static int longestUnivaluePath(TreeNode root) {
        if(root == null){
            return 0;
        }
        res = 0;
        dfs(root);
        return res;
    }

    public static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left), right = dfs(root.right);
        int left1 = 0, right1 = 0;
        if (root.left != null && root.left.val == root.val) {
            left1 = left + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            right1 = right + 1;
        }
        res = Math.max(res, left1 + right1);
        return Math.max(left1, right1);
    }
}
