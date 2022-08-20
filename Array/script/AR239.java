package Array.script;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 239. 滑动窗口最大值
 * <p>
 * 给你一个整数数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 * <p>
 * 1 <= nums.length <= 10e5
 * -10e4 <= nums[i] <= 10e4
 * 1 <= k <= nums.length
 */
public class AR239 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    private static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        //创建双端队列
        Deque<Integer> deque = new ArrayDeque<>();
        //先初始化前K个元素
        for (int i = 0; i < k; i++) {
            //判断队列是否为空 或者当前入队元素是否大于队尾元素 大于则出队
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            //当前元素入队
            //由于需要判断当前元素是否在窗口中，所以实际上队列中存储的为当前元素的下标
            //根据下标找元素比根据元素找下标方便
            deque.offerLast(i);
        }
        int[] ans = new int[n - k + 1];
        //添加当前最大元素
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; i++) {
            //判断队列是否为空 或者当前入队元素是否大于队尾元素 大于则出队
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            //当前元素入队
            deque.offerLast(i);
            //判断队首元素是否在窗口中
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            //添加答案
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }
}
