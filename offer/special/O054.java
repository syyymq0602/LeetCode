package offer.special;

import BT.scripts.TreeNode;
import BT.scripts.TreeNodeUtils;

import java.util.Arrays;

/**
 * 剑指 Offer II 054. 所有大于等于节点的值之和
 *
 * 给定一个二叉搜索树，请将它的每个节点的值替换成树中大于或者等于该节点值的所有节点值之和。
 * 提醒一下，二叉搜索树满足下列约束条件：
 *
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树
 *
 * 树中的节点数介于 0 和 10e4 之间。
 * 每个节点的值介于 -10e4 和 10e4 之间。
 * 树中的所有值 互不相同 。
 * 给定的树为二叉搜索树
 */
public class O054 {
    public static void main(String[] args) {
        var root = TreeNodeUtils.generateByList(
                Arrays.asList(4,1,6,0,2,5,7,null,null,null,3,null,null,null,8));
        var ans = convertBST(root);
    }

    private static int sum;

    private static TreeNode convertBST(TreeNode root) {
        if(root == null){
            return null;
        }
        sum = 0;
        inorder(root);
        return root;
    }

    private static void inorder(TreeNode root) {
        if(root == null){
            return;
        }
        inorder(root.right);
        sum += root.val;
        root.val = sum;
        inorder(root.left);
    }
}
