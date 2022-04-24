package offer.special;

import BT.scripts.TreeNode;
import BT.scripts.TreeNodeUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剑指 Offer II 052. 展平二叉搜索树
 *
 * 给你一棵二叉搜索树，请 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，
 * 并且每个节点没有左子节点，只有一个右子节点
 *
 * 树中节点数的取值范围是 [1, 100]
 * 0 <= Node.val <= 1000
 */
public class O052 {
    public static void main(String[] args) {
        var root = TreeNodeUtils.generateByList(Arrays.asList(5,3,6,2,4,null,8,1,null,null,null,7,9));
        var ans = increasingBST(root);
    }

    private static TreeNode increasingBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        TreeNode head = new TreeNode(list.get(0));
        TreeNode ans = head;
        int n = list.size();
        if(n == 1){
            return head;
        }
        for (int i = 1; i < n; i++) {
            TreeNode cur = new TreeNode(list.get(i));
            head.right = cur;
            head = head.right;
        }
        return ans;
    }

    private static void inorder(TreeNode root, List<Integer> list) {
        if(root == null){
            return;
        }
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
}
