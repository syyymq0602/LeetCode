package offer.scripts;

import BT.scripts.TreeNode;

import java.util.*;

import static BT.scripts.TreeNodeUtils.generateByList;

/**
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 *
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，
 * 第三行再按照从左到右的顺序打印，其他行以此类推。
 *
 * 节点总数 <= 1000
 */
public class o32_3 {
    public static void main(String[] args) {
        var nums = Arrays.asList(3,9,20,null,null,15,7);
        var root = generateByList(nums);
        var res = levelOrder(root);
        System.out.println();
    }

    private static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode curNode;
        boolean mark = true;
        while (!queue.isEmpty()){
            Deque<Integer> deque = new ArrayDeque<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                curNode = queue.poll();
                if(mark){
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
            ans.add(new LinkedList<>(deque));
            mark = !mark;
        }
        return ans;
    }
}
