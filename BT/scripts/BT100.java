package BT.scripts;

/**
 * 100. 相同的树
 *
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 两棵树上的节点数目都在范围 [0, 100] 内
 * -10e4 <= Node.val <= 10e4
 */
public class BT100 {
    public static void main(String[] args) {
        var node1 = new TreeNode(1);
        node1.left = new TreeNode(2);
        var node2 = new TreeNode(1);
        node2.left = new TreeNode(2);
        System.out.println(isSameTree(node1,node2));
    }

    private static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }else if(p == null || q == null){
            return false;
        }else if(p.val != q.val){
            return false;
        }else {
            return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
        }
    }
}
