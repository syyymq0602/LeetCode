package BT.scripts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 114. 二叉树展开为链表
 *
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *
 * 树中结点数在范围 [0, 2000] 内
 * -100 <= Node.val <= 100
 */
public class BT114 {
    public static void main(String[] args) {
        var node = TreeNodeUtils.generateByList(Arrays.asList(1,2,5,3,4,null,6));
        flatten(node);
    }

    private static void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        dfs(root,list);
        for (int i = 1; i < list.size(); i++) {
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    private static void dfs(TreeNode root, List<TreeNode> list) {
        if(root == null){
            return;
        }
        list.add(root);
        dfs(root.left,list);
        dfs(root.right,list);
    }
}
