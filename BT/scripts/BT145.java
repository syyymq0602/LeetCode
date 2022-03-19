package BT.scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 145. 二叉树的后序遍历
 *
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 *
 * 树中节点的数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 */
public class BT145 {
    public static void main(String[] args) {
        var nodes = new TreeNode(4);
        nodes.left = new TreeNode(3);
        nodes.left.left = new TreeNode(2);
        nodes.left.right = new TreeNode(2);
        nodes.left.right.left = new TreeNode(1);
        nodes.right = new TreeNode(3);
        nodes.right.left = new TreeNode(2);
        nodes.right.right = new TreeNode(2);
        nodes.right.left.left = new TreeNode(0);
        System.out.println(postorderTraversal(nodes));
    }

    private static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorder(root,ans);
        return ans;
    }

    private static void inorder(TreeNode root, List<Integer> ans) {
        if(root != null){
            inorder(root.left,ans);
            inorder(root.right,ans);
            ans.add(root.val);
        }
    }

    private static List<Integer> inorder(TreeNode node){
        List<Integer> ans = new ArrayList<>();
        if(node == null){
            return ans;
        }
        Stack<TreeNode> temp = new Stack<>();
        TreeNode cur = node;
        while (node!=null || !temp.isEmpty()){
            while (node != null){
                temp.push(node);
                node = node.left;
            }
            node = temp.pop();
           if(node.right == null || node.right == cur){
               ans.add(node.val);
               cur = node;
               node = null;
           }else {
               temp.push(node);
               node = node.right;
           }
        }
        return ans;
    }
}
