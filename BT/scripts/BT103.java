package BT.scripts;

import java.util.*;

/**
 * 103. 二叉树的锯齿形层序遍历
 *
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 树中节点数目在范围 [0, 2000] 内
 * -100 <= Node.val <= 100
 */
public class BT103 {
    public static void main(String[] args) {
        var nodes = new TreeNode(3);
        nodes.left = new TreeNode(9);
        nodes.right = new TreeNode(20);
        nodes.right.left = new TreeNode(15);
        nodes.right.right = new TreeNode(7);
        for (var item:zigzagLevelOrder(nodes)) {
            System.out.println(item);
        }
    }

    private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        TreeNode curNode;
        boolean isReverse = true;
        while (!queue.isEmpty()){
            Deque<Integer> deque = new ArrayDeque<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                curNode = queue.poll();
                if(isReverse){
                    deque.offerLast(curNode.val);
                }else {
                    deque.offerFirst(curNode.val);
                }
                if(curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if(curNode.right != null){
                    queue.offer(curNode.right);
                }
            }
            isReverse = !isReverse;
            ans.add(new LinkedList<>(deque));
        }
        return ans;
    }
}
