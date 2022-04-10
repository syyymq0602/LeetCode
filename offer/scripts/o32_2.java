package offer.scripts;

import BT.scripts.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static BT.scripts.TreeNodeUtils.generateByList;

/**
 * 剑指 Offer 32 - II. 从上到下打印二叉树 II
 *
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *
 * 节点总数 <= 1000
 */
public class o32_2 {
    public static void main(String[] args) {
        var nums = Arrays.asList(3,9,20,null,null,15,7);
        var root = generateByList(nums);
        var res = levelOrder(root);
        System.out.println();
    }

    private static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if(root == null){
            return ans;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        temp.add(root.val);
        ans.add(new ArrayList<>(temp));
        while (!queue.isEmpty()){
            temp.clear();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if(curr.left != null){
                    temp.add(curr.left.val);
                    queue.offer(curr.left);
                }
                if(curr.right != null){
                    temp.add(curr.right.val);
                    queue.offer(curr.right);
                }
            }
            if(!temp.isEmpty()){
                ans.add(new ArrayList<>(temp));
            }
        }
        return ans;
    }
}
