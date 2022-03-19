package BT.scripts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 110. 平衡二叉树
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 *
 * 树中的节点数在范围 [0, 5000] 内
 * -104 <= Node.val <= 104
 */
public class BT110 {
    public static void main(String[] args) {
        var nodes = new TreeNode(1);
        nodes.right = new TreeNode(2);
        nodes.left = new TreeNode(2);
        nodes.left.right = new TreeNode(3);
        nodes.left.left = new TreeNode(3);
        nodes.left.left.right = new TreeNode(4);
        nodes.left.left.left = new TreeNode(4);
        System.out.println(isBalanced(nodes));
    }

    private static boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        int height = height(root);
        return height > 0;
    }

    private static int height(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        if(leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) >1){
            return -1;
        }
        return Math.max(leftHeight,rightHeight)+1;
    }
}
