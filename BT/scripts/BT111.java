package BT.scripts;

import java.util.ArrayList;
import java.util.List;

/**
 * 111. 二叉树的最小深度
 *
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 *
 * 树中节点数的范围在 [0, 105] 内
 * -1000 <= Node.val <= 1000
 */
public class BT111 {
    public static void main(String[] args) {
        var nodes = new TreeNode(3);
        nodes.left = new TreeNode(9);
        nodes.right = new TreeNode(20);
        nodes.right.left = new TreeNode(15);
        nodes.right.right = new TreeNode(7);
        System.out.println(minDepth(nodes));
    }

    private static int minDepth(TreeNode root,int num) {
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return 0;
        }
        getMin(root,ans,1);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < ans.size(); i++) {
            if(min > ans.get(i)){
                min = ans.get(i);
            }
        }
        return min;
    }

    private static void getMin(TreeNode root, List<Integer> ans, int num) {
        if(root.left == null && root.right == null){
            ans.add(num);
            return;
        }
        num++;
        if(root.left != null){
            getMin(root.left,ans,num);
        }
        if(root.right != null){
            getMin(root.right,ans,num);
        }
    }


    private static int minDepth(TreeNode node){
        if(node == null){
            return 0;
        }

        if(node.left == null && node.right == null){
            return 1;
        }

        int min_depth = Integer.MAX_VALUE;
        if(node.left != null){
            min_depth = Math.min(minDepth(node.left),min_depth);
        }
        if(node.right != null){
            min_depth = Math.min(minDepth(node.right),min_depth);
        }

        return min_depth+1;
    }
}
