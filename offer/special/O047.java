package offer.special;

import BT.scripts.TreeNode;
import BT.scripts.TreeNodeUtils;

import java.util.Arrays;
import java.util.List;

/**
 * 剑指 Offer II 047. 二叉树剪枝
 *
 * 给定一个二叉树 根节点root，树的每个节点的值要么是 0，要么是 1。请剪除该二叉树中所有节点的值为 0 的子树。
 * 节点 node 的子树为node 本身，以及所有 node的后代
 *
 * 二叉树的节点个数的范围是 [1,200]
 * 二叉树节点的值只会是 0 或 1
 */
public class O047 {
    public static void main(String[] args) {
        var root = TreeNodeUtils.generateByList(Arrays.asList(1,null,0,0,1));
        var ans = pruneTree(root);
    }

    private static TreeNode pruneTree(TreeNode root) {
        TreeNode ans = inorder(root);
        return ans;
    }

    private static TreeNode inorder(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode left = inorder(root.left);
        TreeNode right = inorder(root.right);
        if(root.val == 0 && left == null && right == null){
            root = null;
        }else {
            root.left = left;
            root.right = right;
        }
        return root;
    }
}
