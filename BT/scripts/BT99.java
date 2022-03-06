package BT.scripts;

import java.util.ArrayList;
import java.util.List;

/**
 * 99. 恢复二叉搜索树
 *
 * 给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树 。
 *
 * 树上节点的数目在范围 [2, 1000] 内
 * -2e31 <= Node.val <= 2e31 - 1
 */
public class BT99 {
    public static void main(String[] args) {
        var nodes = new TreeNode(3);
        nodes.left = new TreeNode(1);
        nodes.right = new TreeNode(4);
        nodes.right.left = new TreeNode(2);
        recoverTree(nodes);
    }

    private static void recoverTree(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);
        int[] swap = findTwoSwapped(nums);
        recover(root,2,swap[0],swap[1]);
    }

    private static void recover(TreeNode root, int count, int x, int y) {
        if (root != null) {
            if (root.val == x || root.val == y) {
                root.val = root.val == x ? y : x;
                if (--count == 0) {
                    return;
                }
            }
            recover(root.right, count, x, y);
            recover(root.left, count, x, y);
        }
    }

    private static int[] findTwoSwapped(List<Integer> nums) {
        int n = nums.size();
        int index1 = -1,index2 = -1;
        for (int i = 0; i < n - 1; i++) {
            if(nums.get(i+1) < nums.get(i)){
                index2 = i+1;
                if(index1 == -1){
                    index1 = i;
                }else {
                    break;
                }
            }
        }
        int x = nums.get(index1),y=nums.get(index2);
        return new int[]{x,y};
    }

    private static void inorder(TreeNode root, List<Integer> nums) {
        if(root == null){
            return;
        }
        inorder(root.left,nums);
        nums.add(root.val);
        inorder(root.right,nums);
    }
}
