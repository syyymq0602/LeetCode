package LL.scripts;

import java.util.*;

/**
 * 1656. 设计有序流
 *
 * 有 n 个 (id, value) 对，其中 id 是 1 到 n 之间的一个整数，value 是一个字符串。不存在 id 相同的两个(id, value) 对。
 * 设计一个流，以 任意 顺序获取 n个(id, value)对，并在多次调用时 按 id 递增的顺序 返回一些值。
 *
 * 实现 OrderedStream 类：
 * OrderedStream(int n) 构造一个能接收 n 个值的流，并将当前指针 ptr 设为 1 。
 * String[] insert(int id, String value) 向流中存储新的 (id, value) 对。存储后：
 * 如果流存储有 id = ptr 的 (id, value) 对，则找出从 id = ptr 开始的 最长 id 连续递增序列 ，
 * 并 按顺序 返回与这些 id 关联的值的列表。然后，将 ptr 更新为最后那个 id + 1。
 * 否则，返回一个空列表。
 *
 * 1 <= n <= 1000
 * 1 <= id <= n
 * value.length == 5
 * value 仅由小写字母组成
 * 每次调用 insert 都会使用一个唯一的 id
 * 恰好调用 n 次 insert
 */
public class LL1656 {
    public static void main(String[] args) {
        var stream = new OrderedStream(5);
        System.out.println(stream.insert(3,"ccccc").toString());
        System.out.println(stream.insert(1,"aaaaa").toString());
        System.out.println(stream.insert(2,"bbbbb").toString());
        System.out.println(stream.insert(5,"eeeee").toString());
        System.out.println(stream.insert(4,"ddddd").toString());
    }

    static class OrderedStream {

        private int[] keys;
        private Map<Integer,String> map;
        private int top;
        private int prt;

        public OrderedStream(int n) {
            top = n;
            // 下标从1开始
            keys = new int[n+1];
            prt =1;
            map = new HashMap<>();
        }

        public List<String> insert(int idKey, String value) {
            map.put(idKey,value);
            keys[idKey] = idKey;
            List<String> ans = new ArrayList<>();
            if(idKey != prt){
                return ans;
            }
            while (prt <= top && keys[prt] != 0){
                ans.add(map.get(keys[prt]));
                ++prt;
            }
            return ans;
        }
    }
}
