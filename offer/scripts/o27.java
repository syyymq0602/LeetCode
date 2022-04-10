package offer.scripts;

import BT.scripts.TreeNode;

import java.util.Arrays;

import static BT.scripts.TreeNodeUtils.generateByList;

/**
 * 剑指 Offer 27. 二叉树的镜像
 *
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像
 *
 * 0 <= 节点个数 <= 1000
 */
public class o27 {
    public static void main(String[] args) {
        var root = generateByList(Arrays.asList(4,2,7,1,3,6,9));
        var res = mirrorTree(root);
        System.out.println();
    }

    private static TreeNode mirrorTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
