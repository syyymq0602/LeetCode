package offer.special;

/**
 * 剑指 Offer II 029. 排序的循环链表
 * <p>
 * 给定循环单调非递减列表中的一个点，写一个函数向这个列表中插入一个新元素insertVal ，使这个列表仍然是循环升序的。
 * 给定的可以是这个列表中任意一个顶点的指针，并不一定是这个列表中最小元素的指针。
 * 如果有多个满足条件的插入位置，可以选择任意一个位置插入新的值，插入后整个列表仍然保持有序。
 * 如果列表为空（给定的节点是 null），需要创建一个循环有序列表并返回这个节点。否则。请返回原先给定的节点
 * <p>
 * 0 <= Number of Nodes <= 5 * 10^4
 * -10^6 <= Node.val <= 10^6
 * -10^6 <=insertVal <= 10^6
 */
public class O029 {
    public static void main(String[] args) {
        Node head = new Node(3);
        head.next = new Node(4);
        head.next.next = new Node(1);
        head.next.next.next = head;
        var ans = insert(head, 2);
    }

    private static Node insert(Node head, int insertVal) {
        // 创建一个新结点
        Node node = new Node(insertVal);
        // 如果头结点为空，则直接返回新结点
        if (head == null) {
            // 注意是循环链表
            node.next = node;
            return node;
        }
        // 记录前一个结点和当前结点
        Node pre = head, curNode = head.next;
        // 如果链表没有走完一个循环回到起点
        while (curNode != head) {
            // 情况1：可以在中间插入
            if (insertVal >= pre.val && insertVal <= curNode.val) {
                break;
            }
            // 情况2：3 4 1 2，以此为例，pre = 4，curNode = 1，pre是链表中值最大的结点
            if (curNode.val < pre.val) {
                // 待插入结点比现有最大值还大（包含等于情况）
                if (insertVal >= pre.val) {
                    break;
                }
                // 待插入结点比现有最小值还小（包含等于情况）
                if (insertVal <= curNode.val) {
                    break;
                }
            }
            // 往下走一步
            pre = curNode;
            curNode = curNode.next;

        }
        // 插入结点
        node.next = curNode;
        pre.next = node;

        return head;
    }

    static class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

    ;
}
