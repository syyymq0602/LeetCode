package offer.special;

import BT.scripts.TreeNode;
import BT.scripts.TreeNodeUtils;

import java.util.*;

/**
 * 剑指 Offer II 044. 二叉树每层的最大值
 *
 * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值
 *
 * 二叉树的节点个数的范围是 [0,10e4]
 * -2e31 <= Node.val <= 2e31 - 1
 */
public class O044 {
    public static void main(String[] args) {
        var root = TreeNodeUtils.generateByList(Arrays.asList(1,2,3));
        System.out.println(largestValues(root));
    }

    private static List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int maxNum;
        while (!queue.isEmpty()){
            maxNum = Integer.MIN_VALUE;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                maxNum = Math.max(maxNum, temp.val);
                if(temp.left != null){
                    queue.offer(temp.left);
                }
                if(temp.right != null){
                    queue.offer(temp.right);
                }
            }
            ans.add(maxNum);
        }
        return ans;
    }
}
