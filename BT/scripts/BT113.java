package BT.scripts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 113. 路径总和 II
 * <p>
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * 树中节点总数在范围 [0, 5000] 内
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 */
public class BT113 {
    public static void main(String[] args) {
        var list = Arrays.asList(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1);
        var root = generateTreeNode(list);
        var target = -5;
        List<List<Integer>> lists = pathSum(root, target);
        for (var items : lists) {
            var out = "";
            for (var item : items) {
                out += item + " ";
            }
            System.out.println(out);
        }
    }

    private static TreeNode generateTreeNode(List<Integer> list) {
        TreeNode node = new TreeNode(-2);
//        node.left = new TreeNode(list.get(1));
//        node.right = new TreeNode(list.get(2));
//        node.left.left = new TreeNode(list.get(3));
//        node.left.right = null;
//        node.right.left = new TreeNode(list.get(5));
//        node.right.right = new TreeNode(list.get(6));
//        node.left.left.left = new TreeNode(list.get(7));
//        node.left.left.right = new TreeNode(list.get(8));
//        node.right.left.left = null;
//        node.right.left.right = null;
//        node.right.right.left = new TreeNode(list.get(11));
//        node.right.right.right = new TreeNode(list.get(12));
        node.left = null;
        node.right = new TreeNode(-3);
        return node;
    }

    private static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(ans, temp, root, targetSum);
        return ans;
    }

    private static void dfs(List<List<Integer>> ans, List<Integer> temp, TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        temp.add(root.val);
        if(root.left == null && root.right == null && targetSum-root.val == 0){
            ans.add(new ArrayList<>(temp));
        }
        dfs(ans, temp, root.left, targetSum-root.val);
        dfs(ans, temp, root.right, targetSum-root.val);
        temp.remove(temp.size() - 1);
    }
}
