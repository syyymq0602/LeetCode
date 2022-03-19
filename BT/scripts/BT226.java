package BT.scripts;

/**
 * 226. 翻转二叉树
 *
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 *
 * 树中节点数目范围在 [0, 100] 内
 * -100 <= Node.val <= 100
 */
public class BT226 {
    public static void main(String[] args) {
        var nodes = new TreeNode(4);
        nodes.left = new TreeNode(2);
        nodes.right = new TreeNode(7);
        nodes.left.left = new TreeNode(1);
        nodes.left.right = new TreeNode(3);
        nodes.right.left = new TreeNode(6);
        nodes.right.right = new TreeNode(9);
        TreeNode node = invertTree(nodes);
        System.out.println(node);
    }

    private static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    private static void invertTree(TreeNode root, TreeNode copy) {
        if(root == null){
            return;
        }
        invertTree(root.left,copy.right);
        invertTree(root.right,copy.left);
        root.left = copy.right;
        root.right = copy.left;
    }
}
