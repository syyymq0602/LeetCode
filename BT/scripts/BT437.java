package BT.scripts;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 437. 路径总和 III
 *
 * 给定一个二叉树的根节点 root，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 二叉树的节点个数的范围是 [0,1000]
 * -10e9 <= Node.val <= 10e9 
 * -1000 <= targetSum <= 1000
 */
public class BT437 {
    public static void main(String[] args) {
        var root = TreeNodeUtils.generateByList(Arrays.asList(10,5,-3,3,2,null,11,3,-2,null,1));
        System.out.println(pathSum(root,8));
    }

    // 前缀和
    private static int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefix = new HashMap<>();
        prefix.put(0L, 1);
        int ans = dfs(root, prefix, 0, targetSum);
        return ans;
    }

    private static int dfs(TreeNode root, Map<Long, Integer> prefix, long curr, int targetSum) {
        if (root == null) {
            return 0;
        }

        int ret = 0;
        curr += root.val;

        ret = prefix.getOrDefault(curr - targetSum, 0);
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
        ret += dfs(root.left, prefix, curr, targetSum);
        ret += dfs(root.right, prefix, curr, targetSum);
        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);

        return ret;
    }
}
