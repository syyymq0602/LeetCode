package BT.scripts;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 *
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 *
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder 和 inorder 均 无重复 元素
 * inorder 均出现在 preorder
 * preorder 保证 为二叉树的前序遍历序列
 * inorder 保证 为二叉树的中序遍历序列
 *
 */
public class BT105 {
    public static void main(String[] args) {
        var pre = new int[]{3,9,20,15,7};
        var in = new int[]{9,3,15,20,7};
        TreeNode node = buildTree(pre, in);
        System.out.println(node);
    }

    private static TreeNode buildTree(int[] preorder, int[] inorder) {
        int root = -1;
        int index;
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i] == preorder[0]){
                root = preorder[0];
                index = i;
            }
        }
        TreeNode node = new TreeNode(root);
        node.left = buildTree(preorder,inorder);
        node.right = buildTree(preorder,inorder);
        return node;
    }
}
