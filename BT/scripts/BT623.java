package BT.scripts;

import java.util.*;

/**
 * 623. 在二叉树中增加一行
 *
 * 给定一个二叉树的根root和两个整数 val 和depth，在给定的深度depth处添加一个值为 val 的节点行。
 * 注意，根节点root位于深度1。
 * 加法规则如下:
 * 给定整数depth，对于深度为depth - 1 的每个非空树节点 cur ，创建两个值为 val 的树节点作为 cur 的左子树根和右子树根。
 * cur 原来的左子树应该是新的左子树根的左子树。
 * cur 原来的右子树应该是新的右子树根的右子树。
 * 如果 depth == 1 意味着depth - 1根本没有深度，那么创建一个树节点，值 val 作为整个原始树的新根，而原始树就是新根的左子树
 *
 * 节点数在[1, 10e4]范围内
 * 树的深度在[1, 10e4]范围内
 * -100 <= Node.val <= 100
 * -10e5<= val <= 10e5
 * 1 <= depth <= the depth of tree + 1
 */
public class BT623 {
    public static void main(String[] args) {
        var treeNode = TreeNodeUtils.generateByList(Arrays.asList(4, 2, 6, 3, 1, 5));
        var node = addOneRow(treeNode,1,2);
    }

    private static TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }
        List<TreeNode> curLevel = new ArrayList<>();
        curLevel.add(root);
        for (int i = 1; i < depth - 1; i++) {
            List<TreeNode> temp = new ArrayList<>();
            for (TreeNode node : curLevel) {
                if (node.left != null) {
                    temp.add(node.left);
                }
                if (node.right != null) {
                    temp.add(node.right);
                }
            }
            curLevel = temp;
        }
        for (TreeNode node : curLevel) {
            node.left = new TreeNode(val, node.left, null);
            node.right = new TreeNode(val, null, node.right);
        }
        return root;
    }
}
