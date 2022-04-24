package offer.special;

import BT.scripts.TreeNode;
import BT.scripts.TreeNodeUtils;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 剑指 Offer II 053. 二叉搜索树中的中序后继
 *
 * 给定一棵二叉搜索树和其中的一个节点 p ，找到该节点在树中的中序后继。如果节点没有中序后继，请返回 null 。
 * 节点p的后继是值比p.val大的节点中键值最小的节点，即按中序遍历的顺序节点 p 的下一个节点
 *
 * 树中节点的数目在范围 [1, 10e4] 内。
 * -10e5 <= Node.val <= 10e5
 * 树中各节点的值均保证唯一。
 */
public class O053 {
    public static void main(String[] args) {
        var root = TreeNodeUtils.generateByList(Arrays.asList(5,3,6,2,4,null,null,1));
        var p = TreeNodeUtils.generateByList(Arrays.asList(3));
        var ans = inorderSuccessor(root,p);
        var s = 1;
    }

    private static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // 记录当前比 p 节点大的节点
        TreeNode ans = null;
        // 在二叉搜索树中进行搜索
        while(root != null){
            // 如果当前节点 > p，则更新当前比 p 节点大的节点 ans , 同时去左子树进行搜索
            if(root.val > p.val){
                ans = root;
                root = root.left;
            }else{// 如果当前节点 < p , 则到右子树进行搜索
                root = root.right;
            }
        }
        // 当搜寻结束后，ans 保存的就是最近的比 p 节点大的节点。
        return ans;
    }
}
