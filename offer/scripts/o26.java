package offer.scripts;

import BT.scripts.TreeNode;

import java.util.Arrays;

import static BT.scripts.TreeNodeUtils.generateByList;

/**
 * 剑指 Offer 26. 树的子结构
 *
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值
 *
 * 0 <= 节点个数 <= 10000
 */
public class o26 {
    public static void main(String[] args) {
        var A = generateByList(Arrays.asList(4,2,3,4,5,6,7,8,9));
        var B = generateByList(Arrays.asList(4,8,9));
        System.out.println(isSubStructure(A,B));
    }

    private static boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null){
            return false;
        }
        return recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private static boolean recur(TreeNode A, TreeNode B) {
        if(B == null){
            return true;
        }
        if(A== null || A.val != B.val){
            return false;
        }
        return recur(A.left,B.left) && recur(A.right,B.right);
    }
}
