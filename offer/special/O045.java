package offer.special;

import BT.scripts.TreeNode;
import BT.scripts.TreeNodeUtils;

import java.util.*;

/**
 * 剑指 Offer II 045. 二叉树最底层最左边的值
 *
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * 假设二叉树中至少有一个节点
 *
 * 二叉树的节点个数的范围是 [1,10e4]
 * -2e31 <= Node.val <= 2e31 - 1
 */
public class O045 {
    public static void main(String[] args) {
        var root = TreeNodeUtils.generateByList(Arrays.asList(1,2,3,4,null,5,6,null,null,7));
        System.out.println(findBottomLeftValue(root));
    }

    private static int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if(i == 0){
                    list.add(temp.val);
                }
                if(temp.left != null){
                    queue.offer(temp.left);
                }
                if(temp.right != null){
                    queue.offer(temp.right);
                }
            }
        }
        return list.get(list.size()-1);
    }
}
