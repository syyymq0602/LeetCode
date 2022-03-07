package BT.scripts;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 104. 二叉树的最大深度
 *
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class BT104 {
    public static void main(String[] args) {
        var nodes = new TreeNode(3);
        nodes.left = new TreeNode(9);
        nodes.right = new TreeNode(20);
        nodes.right.left = new TreeNode(15);
        nodes.right.right = new TreeNode(7);
        System.out.println(maxDepth(nodes,0));
    }

    private static int maxDepth(TreeNode root) {
        Deque<TreeNode> temp = new ArrayDeque<>();
        if(root == null){
            return 0;
        }
        int num = 0;
        temp.offer(root);
        while (!temp.isEmpty()){
            int currentNum = temp.size();
            for (int i = 0; i < currentNum; i++) {
                root = temp.poll();
                if(root.left!=null){
                    temp.offer(root.left);
                }
                if(root.right != null){
                    temp.offer(root.right);
                }
            }
            num++;
        }
        return num;
    }

    public static int maxDepth(TreeNode root,int num) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left,0);
            int rightHeight = maxDepth(root.right,0);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
