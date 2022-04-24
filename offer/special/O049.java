package offer.special;

import BT.scripts.TreeNode;
import BT.scripts.TreeNodeUtils;

import java.util.Arrays;

/**
 * 剑指 Offer II 049. 从根节点到叶节点的路径数字之和
 *
 * 给定一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * 叶节点 是指没有子节点的节点
 *
 * 树中节点的数目在范围 [1, 1000] 内
 * 0 <= Node.val <= 9
 * 树的深度不超过 10
 */
public class O049 {
    public static void main(String[] args) {
        var root = TreeNodeUtils.generateByList(Arrays.asList(0,1));
        System.out.println(sumNumbers(root));
    }

    private static int sum;

    private static int sumNumbers(TreeNode root) {
//        sum = 0;
//        StringBuilder builder = new StringBuilder();
//        inorder(root,builder);
//        return sum;
        return dfs(root,0);
    }

    private static void inorder(TreeNode root,StringBuilder builder) {
        if(root.left == null && root.right == null){
            sum += Integer.parseInt(builder.toString() + root.val);
            return;
        }
        builder.append(root.val);
        if(root.left != null){
            inorder(root.left,builder);
        }
        if(root.right != null){
            inorder(root.right,builder);
        }
        builder.deleteCharAt(builder.length()-1);
    }

    public static int dfs(TreeNode root, int prevSum) {
        if (root == null) {
            return 0;
        }
        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }
}
