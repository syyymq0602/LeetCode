package BT.scripts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 *
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 *
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 */
public class BT94 {
    public final static List<Integer> list = Arrays.asList(1,null,2,3);
    public static void main(String[] args) {
        var nodes = new TreeNode(1);
        nodes.left = new TreeNode(2);
        nodes.left.left = new TreeNode(6);
        nodes.left.right = new TreeNode(7);
        nodes.left.left.left = new TreeNode(100);
        nodes.right = new TreeNode(4);
        nodes.right.left = new TreeNode(3);
        nodes.right.right = new TreeNode(5);
        System.out.println(inorderTraversal(nodes));
    }

    private static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        res = inorder(root);
        return res;
    }

    private static void inorder(TreeNode node, List<Integer> list){
        if(node != null){
            inorder(node.left,list);
            list.add(node.val);
            inorder(node.right,list);
        }
    }

    private static List<Integer> inorder(TreeNode node){
        List<Integer> ans = new ArrayList<>();
        if(node == null){
            return ans;
        }
        Stack<TreeNode> temp = new Stack<>();
        TreeNode cur = node;
        while (cur!=null || !temp.isEmpty()){
            while (cur!=null){
                temp.push(cur);
                cur = cur.left;
            }
            if(!temp.isEmpty()){
                cur = temp.pop();
                ans.add(cur.val);
                cur = cur.right;
            }
        }
        return ans;
    }

    private static TreeNode generateTreeNode(TreeNode node,int index){
        if(index >= list.size() || list.get(index) == null){
            return null;
        }
        else {
            node.setVal(list.get(index));
        }
        node.left = generateTreeNode(new TreeNode(),++index);
        node.right = generateTreeNode(new TreeNode(),++index);
        return node;
    }
}
