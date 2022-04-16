package offer.special;

import java.util.*;

/**
 * 剑指 Offer II 030. 插入、删除和随机访问都是 O(1) 的容器
 * <p>
 * 设计一个支持在平均时间复杂度 O(1)下，执行以下操作的数据结构：
 * <p>
 * insert(val)：当元素 val 不存在时返回 true，并向集合中插入该项，否则返回 false 。
 * remove(val)：当元素 val 存在时返回 true，并从集合中移除该项，否则返回 false。
 * getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。
 * <p>
 * -2e31<= val <= 2e31- 1
 * 最多进行 2 * 10e5 次insert ， remove 和 getRandom 方法调用
 * 当调用getRandom 方法时，集合中至少有一个元素
 */
public class O030 {
    public static void main(String[] args) {

        RandomizedSet obj = new RandomizedSet();
        boolean param_1 = obj.insert(2);
        System.out.println(param_1);
        boolean param_2 = obj.remove(3);
        System.out.println(param_2);
        int param_3 = obj.getRandom();
        System.out.println(param_3);
    }

    static class RandomizedSet {

        Set<Integer> map;
        int count;
        List<Integer> list;
        Random random;

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {
            map = new HashSet<>();
            count = 0;
            list = new ArrayList<>();
            random = new Random();
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (map.contains(val)) {
                return false;
            }
            map.add(val);
            count++;
            return true;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (!map.contains(val)) {
                return false;
            }
            map.remove(val);
            count--;
            return true;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            int nextInt = random.nextInt(count);
            Object[] array = map.toArray();
            return (int) array[nextInt];
        }
    }
}
