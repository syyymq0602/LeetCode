package offer.special;

import BT.scripts.TreeNode;
import BT.scripts.TreeNodeUtils;

import java.util.Arrays;

/**
 * 剑指 Offer II 051. 节点之和最大的路径
 *
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。
 * 该路径 至少包含一个 节点，且不一定经过根节点。
 * 给定一个二叉树的根节点 root ，返回其 最大路径和，即所有路径上节点值之和的最大值
 *
 * 树中节点数目范围是 [1, 3 * 10e4]
 * -1000 <= Node.val <= 1000
 */
public class O051 {
    private static int max;
    public static void main(String[] args) {
        var root = TreeNodeUtils.generateByList(Arrays.asList(1,-2,-3,1,3,-2,null,-1));
        System.out.println(maxPathSum(root));
    }

    private static int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        maxGain(root);
        return max;
    }

    private static int maxGain(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 递归计算左右子节点的最大贡献值
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        int leftGain = Math.max(maxGain(root.left), 0);
        int rightGain = Math.max(maxGain(root.right), 0);

        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        int priceNewpath = root.val + leftGain + rightGain;

        // 更新答案
        max = Math.max(max, priceNewpath);

        // 返回节点的最大贡献值
        return root.val + Math.max(leftGain, rightGain);
    }
}
