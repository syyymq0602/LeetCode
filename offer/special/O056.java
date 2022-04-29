package offer.special;

import BT.scripts.TreeNode;
import BT.scripts.TreeNodeUtils;

import java.util.*;

/**
 * 剑指 Offer II 056. 二叉搜索树中两个节点之和
 *
 * 给定一个二叉搜索树的 根节点 root 和一个整数 k , 请判断该二叉搜索树中是否存在两个节点它们的值之和等于 k 。假设二叉搜索树中节点的值均唯一
 *
 * 二叉树的节点个数的范围是  [1, 10e4].
 * -10e4 <= Node.val <= 10e4
 * root 为二叉搜索树
 * -10e5 <= k <= 10e5
 */
public class O056 {
    public static void main(String[] args) {
        var root = TreeNodeUtils.generateByList(Arrays.asList(8,6,10,5,7,9,11));
        System.out.println(findTarget(root,22));
    }

    private static boolean findTarget(TreeNode root, int k) {
        if(root == null){
            return false;
        }
        Set<Integer> set = new HashSet<>();
        boolean ans = inorder(set,root,k);
        return ans;
    }

    private static boolean inorder(Set<Integer> set, TreeNode root, int k) {
        if(root == null){
            return false;
        }
        if(set.contains(root.val)){
            return true;
        }else {
            set.add(k - root.val);
        }
        return inorder(set,root.left,k) || inorder(set,root.right,k);
    }
}
