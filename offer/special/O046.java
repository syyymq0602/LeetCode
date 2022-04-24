package offer.special;

import BT.scripts.TreeNode;
import BT.scripts.TreeNodeUtils;

import java.util.*;

/**
 * 剑指 Offer II 046. 二叉树的右侧视图
 *
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值
 *
 * 二叉树的节点个数的范围是 [0,100]
 * -100 <= Node.val <= 100
 */
public class O046 {
    public static void main(String[] args) {
        var root = TreeNodeUtils.generateByList(Arrays.asList(1,2,3,null,5,null,4));
        System.out.println(rightSideView(root));
    }

    private static List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if(i == 0){
                    ans.add(poll.val);
                }
                if(poll.right != null){
                    queue.add(poll.right);
                }
                if(poll.left != null){
                    queue.add(poll.left);
                }
            }
        }
        return ans;
    }
}
