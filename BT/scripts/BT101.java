package BT.scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 101. 对称二叉树
 *
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 *
 * 树中节点数目在范围 [1, 1000] 内
 * -100 <= Node.val <= 100
 */
public class BT101 {

    public static void main(String[] args) {
        var nodes = new TreeNode(1);
        nodes.left = new TreeNode(2);
        nodes.left.right = new TreeNode(3);
        nodes.right = new TreeNode(2);
        nodes.right.left = new TreeNode(3);
        System.out.println(isSymmetric(nodes));
    }

    private static boolean isSymmetric(TreeNode root) {
        return check(root,root);
    }

    private static boolean check(TreeNode root, TreeNode root1) {
        if(root == null && root1 == null){
            return true;
        }else if(root == null || root1 == null){
            return false;
        }else if(root.val != root1.val){
            return false;
        }else{
            return check(root.left,root1.right)&&check(root.right,root1.left);
        }
    }
}
