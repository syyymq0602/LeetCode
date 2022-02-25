package BT.scripts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        var root = new TreeNode();
        var node = generateTreeNode(root,0);
        System.out.println(inorderTraversal(node));
    }

    private static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root,res);
        return res;
    }

    private static void inorder(TreeNode node, List<Integer> list){
        if(node != null){
            inorder(node.left,list);
            list.add(node.val);
            inorder(node.right,list);
        }
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
