package offer.special;


import java.util.LinkedList;

/**
 * 剑指 Offer II 041. 滑动窗口的平均值
 * <p>
 * 给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算滑动窗口里所有数字的平均值。
 * 实现 MovingAverage 类：
 * MovingAverage(int size) 用窗口大小 size 初始化对象。
 * double next(int val)成员函数 next每次调用的时候都会往滑动窗口增加一个整数，
 * 请计算并返回数据流中最后 size 个值的移动平均值，即滑动窗口里所有数字的平均值
 * <p>
 * 1 <= size <= 1000
 * -10e5 <= val <= 10e5
 * 最多调用 next 方法 10e4 次
 */
public class O041 {
    public static void main(String[] args) {
        MovingAverage obj = new MovingAverage(3);
        double param_1 = obj.next(1);
        System.out.println(param_1);
        double param_2 = obj.next(10);
        System.out.println(param_2);
        double param_3 = obj.next(3);
        System.out.println(param_3);
        double param_4 = obj.next(5);
        System.out.println(param_4);
    }

    static class MovingAverage {
        double sum;
        LinkedList<Integer> queue;
        int total;
        int count;

        /**
         * Initialize your data structure here.
         */
        public MovingAverage(int size) {
            sum = 0;
            total = size;
            queue = new LinkedList<>();
            count = 0;
        }

        public double next(int val) {
            if (count < total) {
                sum += val;
                queue.offer(val);
                count++;

            } else {
                int old = queue.poll();
                sum = sum - old + val;
                queue.offer(val);
            }
            return sum / count;
        }
    }
}
