package DP.scripts;

import BT.scripts.TreeNode;
import BT.scripts.TreeNodeUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 337. 打家劫舍 III
 *
 * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为root。
 * 除了root之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
 * 给定二叉树的root。返回在不触动警报的情况下，小偷能够盗取的最高金额
 *
 * 树的节点数在 [1, 10e4] 范围内
 * 0 <= Node.val <= 10e4
 */
public class DP337 {
    public static void main(String[] args) {
        var node = TreeNodeUtils.generateByList(Arrays.asList(3,2,3,null,3,null,1));
        System.out.println(rob(node));
    }

    static Map<TreeNode, Integer> f;
    static Map<TreeNode, Integer> g;

    private static int rob(TreeNode root) {
        f = new HashMap<>();
        g = new HashMap<>();
        dfs(root);
        return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
    }

    private static void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        dfs(node.right);
        f.put(node, node.val + g.getOrDefault(node.left, 0) + g.getOrDefault(node.right, 0));
        g.put(node, Math.max(f.getOrDefault(node.left, 0), g.getOrDefault(node.left, 0)) +
                Math.max(f.getOrDefault(node.right, 0), g.getOrDefault(node.right, 0)));
    }
}
