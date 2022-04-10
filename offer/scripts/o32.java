package offer.scripts;

import BT.scripts.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static BT.scripts.TreeNodeUtils.generateByList;

/**
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 *
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *
 * 节点总数 <= 1000
 */
public class o32 {
    public static void main(String[] args) {
        var nums = Arrays.asList(3,9,20,null,null,15,7);
        var root = generateByList(nums);
        var s = "";
        for (var item:levelOrder(root)) {
            s += item + " ";
        }
        System.out.println(s);
    }

    private static int[] levelOrder(TreeNode root) {
        if(root == null){
            return new int[]{};
        }
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        list.add(root.val);
        while (!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(curr.left != null){
                list.add(curr.left.val);
                queue.offer(curr.left);
            }
            if(curr.right != null){
                list.add(curr.right.val);
                queue.offer(curr.right);
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
