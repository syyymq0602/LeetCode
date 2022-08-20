package LL.scripts;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 146. LRU 缓存
 *
 * 请你设计并实现一个满足 LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value)如果关键字key 已经存在，则变更其数据值value ；如果不存在，则向缓存中插入该组key-value 。
 * 如果插入操作导致关键字数量超过capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 *
 * 1 <= capacity <= 3000
 * 0 <= key <= 10000
 * 0 <= value <= 10e5
 * 最多调用 2 * 10e5 次 get 和 put
 */
public class LL146 {
    public static void main(String[] args) {
        var lru = new LRUCache(2);
        lru.put(1,1);
        lru.put(2,2);
        System.out.println(lru.get(1));
        lru.put(3,3);
        System.out.println(lru.get(2));
        lru.put(4,4);
        System.out.println(lru.get(1));
        System.out.println(lru.get(3));
        System.out.println(lru.get(4));
    }

    static class LRUCache {

        private Node head;
        private Node tail;
        private Map<Integer,Node> nodeMap;
        private int capacity;
        private int count;
        public LRUCache(int capacity) {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.pre = head;
            nodeMap = new HashMap<>();
            this.capacity = capacity;
            count = 0;
        }

        public int get(int key) {
            Node node = nodeMap.get(key);
            if(node == null){
                return -1;
            }
            moveToHead(node);
            return node.val;
        }

        public void put(int key, int value) {
            Node node = nodeMap.get(key);
            if(node == null){
                Node newNode = new Node(key,value);
                nodeMap.put(key,newNode);
                addToHead(newNode);
                count++;
                if(count > capacity){
                    Node t = removeTail();
                    nodeMap.remove(t.key);
                    --count;
                }
            }else {
                node.val = value;
                moveToHead(node);
            }
        }

        private void moveToHead(Node node) {
            removeNode(node);
            addToHead(node);
        }

        private Node removeTail(){
            Node res = tail.pre;
            removeNode(res);
            return res;
        }

        private void addToHead(Node node){
            node.pre = head;
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
        }

        private void removeNode(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        static class Node{
            public Node pre;
            public Node next;
            public int val;
            public int key;

            public Node(){}

            public Node(int key,int val){
                this.val = val;
                this.key = key;
            }
        }
    }
}
