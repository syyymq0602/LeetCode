package LL.scripts;

/**
 * 641. 设计循环双端队列
 *
 * 设计实现双端队列。
 *
 * 实现 MyCircularDeque 类:
 * MyCircularDeque(int k)：构造函数,双端队列最大为 k 。
 * boolean insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true，否则返回 false 。
 * boolean insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true，否则返回 false 。
 * boolean deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true，否则返回 false 。
 * boolean deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true，否则返回 false 。
 * int getFront())：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
 * int getRear()：获得双端队列的最后一个元素。如果双端队列为空，返回 -1 。
 * boolean isEmpty()：若双端队列为空，则返回true，否则返回 false 。
 * boolean isFull()：若双端队列满了，则返回true，否则返回 false 。
 *
 * 1 <= k <= 1000
 * 0 <= value <= 1000
 * insertFront,insertLast,deleteFront,deleteLast,getFront,getRear,isEmpty,isFull 调用次数不大于2000次
 */
public class LL641 {
    public static void main(String[] args) {
        var circularDeque  = new MyCircularDeque(3);
        System.out.println(circularDeque.insertLast(1));			        // 返回 true
        System.out.println(circularDeque.insertLast(2));			        // 返回 true
        System.out.println(circularDeque.insertFront(3));			        // 返回 true
        System.out.println(circularDeque.insertFront(4));			        // 已经满了，返回 false
        System.out.println(circularDeque.getRear());  				// 返回 2
        System.out.println(circularDeque.isFull());				        // 返回 true
        System.out.println(circularDeque.deleteLast());			        // 返回 true
        System.out.println(circularDeque.insertFront(4));			        // 返回 true
        System.out.println(circularDeque.getFront());
    }

    static class MyCircularDeque {

        private MyNode head;
        private MyNode tail;
        private int top;
        private int count;

        public MyCircularDeque(int k) {
            head = new MyNode();
            tail = new MyNode();
            top = k;
            count = 0;
            head.next = tail;
            tail.pre = head;
        }

        public boolean insertFront(int value) {
            if(count == top){
                return false;
            }
            MyNode node = new MyNode(value);
            node.next = head.next;
            head.next.pre = node;
            node.pre = head;
            head.next = node;
            ++count;
            return true;
        }

        public boolean insertLast(int value) {
            if(count == top){
                return false;
            }
            MyNode node = new MyNode(value);
            node.pre = tail.pre;
            tail.pre.next = node;
            node.next = tail;
            tail.pre = node;
            ++count;
            return true;
        }

        public boolean deleteFront() {
            if(count == 0){
                return false;
            }
            head.next.next.pre = head;
            head.next = head.next.next;
            --count;
            return true;
        }

        public boolean deleteLast() {
            if(count == 0){
                return false;
            }
            tail.pre.pre.next = tail;
            tail.pre = tail.pre.pre;
            --count;
            return true;
        }

        public int getFront() {
            if(count == 0){
                return -1;
            }
            return head.next.value;
        }

        public int getRear() {
            if(count == 0){
                return -1;
            }
            return tail.pre.value;
        }

        public boolean isEmpty() {
            return count == 0;
        }

        public boolean isFull() {
            return count == top;
        }

        class MyNode {

            public MyNode pre;
            public MyNode next;
            public int value;

            public MyNode(){

            }

            public MyNode(int val){
                value = val;
            }
        }
    }
}
