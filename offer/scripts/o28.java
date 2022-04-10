package offer.scripts;

import BT.scripts.TreeNode;

import java.util.Arrays;

import static BT.scripts.TreeNodeUtils.generateByList;

/**
 * 剑指 Offer 28. 对称的二叉树
 *
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 0 <= 节点个数 <= 1000
 */
public class o28 {
    public static void main(String[] args) {
        var root = generateByList(Arrays.asList(1,2,2,3,4,4,3));
        var res = isSymmetric(root);
        System.out.println(res);
    }

    private static boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return check(root,root);
    }

    private static boolean check(TreeNode root, TreeNode root1) {
        if(root == null && root1 == null){
            return true;
        }else if(root == null || root1 == null){
            return false;
        }else if(root.val != root1.val){
            return false;
        }else {
            return check(root.left,root1.right) && check(root.right,root1.left);
        }
    }
}
