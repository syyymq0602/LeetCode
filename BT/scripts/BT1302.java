package BT.scripts;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * 1302. 层数最深叶子节点的和
 *
 * 给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和
 *
 * 树中节点数目在范围 [1, 10e4] 之间。
 * 1 <= Node.val <= 100
 */
public class BT1302 {
    public static void main(String[] args) {
        var node = TreeNodeUtils.generateByList(Arrays.asList(1,2,3,4,5,null,6,7,null,null,null,null,8));
        System.out.println(deepestLeavesSum(node));
        System.out.println(deepestLeavesSum(node,false));
    }

    private static int deepestLeavesSum(TreeNode root) {
        int sum = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if(temp.left!=null){
                    queue.offer(temp.left);
                }
                if(temp.right!=null){
                    queue.offer(temp.right);
                }
                sum += temp.val;
            }
        }
        return sum;
    }

    private static int maxLevel;
    private static int sum;

    private static int deepestLeavesSum(TreeNode root,boolean flag) {
        sum = 0;
        maxLevel = 0;
        dfs(root,0);
        return sum;
    }

    private static void dfs(TreeNode root, int level) {
        if(root == null){
            return;
        }
        if(level > maxLevel){
            maxLevel = level;
            sum = root.val;
        } else if (maxLevel == level) {
            sum += root.val;
        }
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }
}
