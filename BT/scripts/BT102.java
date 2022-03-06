package BT.scripts;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 *
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 *
 * 树中节点数目在范围 [0, 2000] 内
 * -1000 <= Node.val <= 1000
 */
public class BT102 {
    public static void main(String[] args) {
        var nodes = new TreeNode(1);
        nodes.left = new TreeNode(2);
        nodes.right = new TreeNode(3);
        nodes.left.left = new TreeNode(4);
        nodes.right.right = new TreeNode(5);
        System.out.println(levelOrder(nodes).size());
    }

    private static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        TreeNode node;
        List<Integer> temp = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            temp.clear();
            int current = queue.size();
            for (int i = 1; i <= current; i++) {
                node = queue.poll();
                temp.add(node.val);
                if(node.left !=null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            ans.add(new ArrayList<>(temp));
        }
        return ans;
    }
}
