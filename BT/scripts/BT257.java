package BT.scripts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 *
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 * 树中节点的数目在范围 [1, 100] 内
 * -100 <= Node.val <= 100
 */
public class BT257 {
    public static void main(String[] args) {
        List<Integer> rootList = Arrays.asList(1,2,3,null,5);
        var root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = null;
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        System.out.println(binaryTreePaths(root).size());
    }

    private static List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        dfs(ans,root,"");
        return ans;
    }

    private static void dfs(List<String> ans, TreeNode root, String builder) {
        StringBuffer buffer = new StringBuffer(builder);
        buffer.append(root.val+"");
        if(root.left == null && root.right == null){
            ans.add(buffer.toString());
            return;
        }
        buffer.append("->");
        if(root.left != null){
            dfs(ans,root.left,buffer.toString());
        }
        if(root.right != null){
            dfs(ans,root.right,buffer.toString());
        }
    }

    private static TreeNode generateTreeNode(TreeNode node, int index, List<Integer> rootList){
        if(index >= rootList.size() || rootList.get(index) == null){
            return null;
        }
        else {
            node.setVal(rootList.get(index));
        }
        node.left = generateTreeNode(new TreeNode(),++index, rootList);
        node.right = generateTreeNode(new TreeNode(),++index, rootList);
        return node;
    }
}
