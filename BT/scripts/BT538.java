package BT.scripts;

import java.util.Arrays;

/**
 * 538. 把二叉搜索树转换为累加树
 *
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），
 * 使每个节点 node的新值等于原树中大于或等于node.val的值之和。
 *
 * 提醒一下，二叉搜索树满足下列约束条件：
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 *
 * 树中的节点数介于 0 和 10e4 之间。
 * 每个节点的值介于 -10e4 和 10e4 之间。
 * 树中的所有值 互不相同 。
 * 给定的树为二叉搜索树。
 */
public class BT538 {
    public static void main(String[] args) {
        var root = TreeNodeUtils.generateByList(Arrays.asList(4,1,6,0,2,5,7,null,null,null,3,null,null,null,8));
        System.out.println(TreeNodeUtils.ListNodeToString(convertBST(root)));
    }

    private static int sum;
    private static TreeNode convertBST(TreeNode root) {
        sum = 0;
        dfs(root);
        return root;
    }

    private static void dfs(TreeNode root) {
        if(root == null){
            return;
        }
        dfs(root.right);
        sum += root.val;
        root.val = sum;
        dfs(root.left);
    }
}
