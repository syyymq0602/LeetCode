package offer.scripts;

import BT.scripts.TreeNode;
import BT.scripts.TreeNodeUtils;

import java.util.*;

/**
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 *
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 叶子节点 是指没有子节点的节点。
 *
 * 树中节点总数在范围 [0, 5000] 内
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 */
public class o34 {
    public static void main(String[] args) {
        var tree = TreeNodeUtils.generateByList(Arrays.asList(5,4,8,11,null,13,4,7,2,null,null,5,1));
        var ans = pathSum(tree,22);
        for (var item:ans) {
            System.out.println(item.toString());
        }
    }

    private static List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        pathSum(root,target,ans,temp);
        return ans;
    }

    private static void pathSum(TreeNode root, int target, List<List<Integer>> ans, List<Integer> temp) {
        if(root == null){
            return;
        }
        temp.add(root.val);
        target = target - root.val;
        if(target == 0 && root.left ==null && root.right == null){
            ans.add(new ArrayList<>(temp));
            temp.remove(temp.size()-1);
            return;
        }
        pathSum(root.left,target,ans,temp);
        pathSum(root.right,target,ans,temp);
        temp.remove(temp.size()-1);
    }
}
