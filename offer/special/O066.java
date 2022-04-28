package offer.special;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 066. 单词之和
 * <p>
 * 实现一个 MapSum 类，支持两个方法，insert和sum：
 * MapSum() 初始化 MapSum 对象
 * void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 key 已经存在，那么原来的键值对将被替代成新的键值对。
 * int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和
 * <p>
 * 1 <= key.length, prefix.length <= 50
 * key 和 prefix 仅由小写英文字母组成
 * 1 <= val <= 1000
 * 最多调用 50 次 insert 和 sum
 */
public class O066 {
    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("ap"));
        mapSum.insert("app", 2);
        System.out.println(mapSum.sum("ap"));
        mapSum.insert("a",100);
        System.out.println(mapSum.sum("a"));
    }

    private static class MapSum {
        class TrieNode {
            int val = 0;
            TrieNode[] next = new TrieNode[26];
        }

        TrieNode root;
        Map<String, Integer> map;

        public MapSum() {
            root = new TrieNode();
            map = new HashMap<>();
        }

        public void insert(String key, int val) {
            int delta = val - map.getOrDefault(key, 0);
            map.put(key, val);
            TrieNode node = root;
            for (char c : key.toCharArray()) {
                if (node.next[c - 'a'] == null) {
                    node.next[c - 'a'] = new TrieNode();
                }
                node = node.next[c - 'a'];
                node.val += delta;
            }
        }

        public int sum(String prefix) {
            TrieNode node = root;
            for (char c : prefix.toCharArray()) {
                if (node.next[c - 'a'] == null) {
                    return 0;
                }
                node = node.next[c - 'a'];
            }
            return node.val;
        }
    }
}
