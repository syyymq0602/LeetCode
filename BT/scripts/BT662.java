package BT.scripts;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 662. 二叉树最大宽度
 * <p>
 * 给你一棵二叉树的根节点 root ，返回树的 最大宽度 。
 * 树的 最大宽度 是所有层中最大的 宽度 。
 * 每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。
 * 将这个二叉树视作与满二叉树结构相同，两端点间会出现一些延伸到这一层的 null 节点，这些 null 节点也计入长度。
 * 题目数据保证答案将会在 32 位 带符号整数范围内
 * <p>
 * 树中节点的数目范围是 [1, 3000]
 * -100 <= Node.val <= 100
 */
public class BT662 {
    public static void main(String[] args) {
        var root = TreeNodeUtils.generateByList(Arrays.asList(1, 3, 2, 5, 3, null, 9));
        System.out.println(widthOfBinaryTree(root));
    }

    private static int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int ans = 0;
        Deque<TreeNode> queue = new LinkedList<>();
        root.val = 0;
        queue.offer(root);
        while (queue.size() > 0) {
            int n = queue.size();
            ans = Math.max(ans, queue.peekLast().val - queue.peekFirst().val + 1);
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    node.left.val = 2 * node.val;
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    node.right.val = 2 * node.val + 1;
                    queue.offer(node.right);
                }
            }
        }
        return ans;
    }
}
