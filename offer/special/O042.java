package offer.special;

import java.util.LinkedList;

/**
 * 剑指 Offer II 042. 最近请求次数
 *
 * 写一个RecentCounter类来计算特定时间范围内最近的请求。
 *
 * 请实现 RecentCounter 类：
 *
 * RecentCounter() 初始化计数器，请求数为 0 。
 * int ping(int t) 在时间 t 添加一个新请求，其中 t 表示以毫秒为单位的某个时间，并返回过去 3000 毫秒内发生的所有请求数（包括新请求）。
 * 确切地说，返回在 [t-3000, t] 内发生的请求数。
 * 保证 每次对 ping 的调用都使用比之前更大的 t 值
 *
 * 1 <= t <= 10e9
 * 保证每次对 ping 调用所使用的 t 值都 严格递增
 * 至多调用 ping 方法 10e4 次
 */
public class O042 {
    public static void main(String[] args) {
        RecentCounter r = new RecentCounter();
        System.out.println(r.ping(1));
        System.out.println(r.ping(100));
        System.out.println(r.ping(3001));
        System.out.println(r.ping(3002));
        System.out.println(r.ping(4002));
    }

    static class RecentCounter {
        LinkedList<Integer> deque;
        int count;
        int min;
        public RecentCounter() {
            deque = new LinkedList<>();
            count = 0;
        }

        public int ping(int t) {
            deque.offer(t);
            count++;
            min = t - 3000;
            while (deque.peekFirst() < min){
                deque.pollFirst();
                count--;
            }
            return count;
        }
    }
}
