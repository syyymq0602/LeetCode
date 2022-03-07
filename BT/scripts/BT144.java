package BT.scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. 二叉树的前序遍历
 *
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 *
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 */
public class BT144 {
    public static void main(String[] args) {
        var nodes = new TreeNode(1);
        nodes.left = new TreeNode(2);
        nodes.left.left = new TreeNode(6);
        nodes.left.right = new TreeNode(7);
        nodes.left.left.left = new TreeNode(100);
        nodes.right = new TreeNode(4);
        nodes.right.left = new TreeNode(3);
        nodes.right.right = new TreeNode(5);
        System.out.println(preorderTraversal(nodes));
    }

    private static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        ans = inorder(root);
        return ans;
    }

    private static void inorder(TreeNode root, List<Integer> ans) {
        if(root != null){
            ans.add(root.val);
            inorder(root.left,ans);
            inorder(root.right,ans);
        }
    }

    private static List<Integer> inorder(TreeNode node){
        List<Integer> ans = new ArrayList<>();
        if(node == null){
            return ans;
        }
        Stack<TreeNode> temp = new Stack<>();
        temp.push(node);
        while (!temp.isEmpty()){
            node = temp.pop();
            if(node!=null){
                ans.add(node.val);
            }
            else {
                continue;
            }
            temp.push(node.right);
            temp.push(node.left);
        }
        return ans;
    }
}
