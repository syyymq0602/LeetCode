package offer.special;

import java.util.PriorityQueue;

/**
 * 剑指 Offer II 059. 数据流的第 K 大数值
 *
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 * 请实现 KthLargest类：
 * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 * int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素
 *
 * 1 <= k <= 10e4
 * 0 <= nums.length <= 10e4
 * -10e4 <= nums[i] <= 10e4
 * -10e4 <= val <= 104
 * 最多调用 add 方法 10e4 次
 * 题目数据保证，在查找第 k 大元素时，数组中至少有 k 个元素
 */
public class O059 {
    public static void main(String[] args) {
        var kthLargest  = new KthLargest(3,new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }

    private static class KthLargest {
        int k;
        PriorityQueue<Integer> pq;
        public KthLargest(int k, int[] nums) {
            this.k = k;
            pq = new PriorityQueue<>();
            for (int x : nums){
                add(x);
            }
        }

        public int add(int val) {
            pq.offer(val);
            if(pq.size() > k){
                pq.poll();
            }
            return pq.peek();
        }
    }
}
