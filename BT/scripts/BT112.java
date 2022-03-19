package BT.scripts;

/**
 * 112. 路径总和
 *
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 * 树中节点的数目在范围 [0, 5000] 内
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 */
public class BT112 {
    public static void main(String[] args) {
        var nodes = new TreeNode(5);
        nodes.left = new TreeNode(4);
        nodes.left.left = new TreeNode(12);
        nodes.left.left.left = new TreeNode(7);
        nodes.left.left.right = new TreeNode(2);
        nodes.right = new TreeNode(8);
        nodes.right.left = new TreeNode(13);
        nodes.right.right = new TreeNode(4);
        nodes.right.right.right = new TreeNode(1);
        var node = new TreeNode(1);
        node.left = new TreeNode(2);
        System.out.println(hasPathSum(nodes,22));
    }

    private static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        targetSum = targetSum - root.val;
        if(targetSum == 0 && root.left == null && root.right == null){
            return true;
        }
        return hasPathSum(root.left,targetSum) || hasPathSum(root.right,targetSum);
    }
}
