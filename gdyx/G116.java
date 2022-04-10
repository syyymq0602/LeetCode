package gdyx;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 *
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有next 指针都被设置为 NULL。
 *
 * 树中节点的数量在 [0, 212 - 1] 范围内
 * -1000 <= node.val <= 1000
 */
public class G116 {
    public static void main(String[] args) {
        var n1 = new Node(1);
        n1.left = new Node(2);
        n1.left.left = new Node(4);
        n1.left.right = new Node(5);
        n1.right = new Node(3);
        n1.right.left = new Node(6);
        n1.right.right = new Node(7);
        var res = connect(n1);
        System.out.println();
    }

    private static Node connect(Node root) {
        if(root == null){
            return null;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if(i < size-1){
                    node.next = queue.peek();
                }
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}


