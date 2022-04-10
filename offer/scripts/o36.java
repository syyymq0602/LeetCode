package offer.scripts;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 36. 二叉搜索树与双向链表
 *
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 *
 *
 */
public class o36 {
    public static void main(String[] args) {
        Node node = new Node(4);
        node.left = new Node(2);
        node.left.left = new Node(1);
        node.left.right = new Node(3);
        node.right = new Node(5);
        var ans = treeToDoublyList(node);
        System.out.println();
    }

    static Node head,pre;

    private static Node treeToDoublyList(Node root) {
        if(root == null){
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private static void dfs(Node root) {
        if(root == null){
            return;
        }
        dfs(root.left);
        if(pre == null){
            head = root;
        }else {
            pre.right = root;
        }
        root.left = pre;
        pre = root;
        dfs(root.right);
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
