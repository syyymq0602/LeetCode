package Array.script;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 768. 最多能完成排序的块 II
 *
 * arr是一个可能包含重复元素的整数数组，我们将这个数组分割成几个“块”，并将这些块分别进行排序。之后再连接起来，使得连接的结果和按升序排序后的原数组相同。
 * 我们最多能将数组分成多少块
 *
 * arr的长度在[1, 2000]之间。
 * arr[i]的大小在[0, 10e8]之间。
 */
public class AR768 {
    public static void main(String[] args) {
        System.out.println(maxChunksToSorted(new int[]{1,2,4,5,3,6}));
    }

    private static int maxChunksToSorted(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int num : arr) {
            if (stack.isEmpty() || num >= stack.peek()) {
                stack.push(num);
            } else {
                int mx = stack.pop();
                while (!stack.isEmpty() && stack.peek() > num) {
                    stack.pop();
                }
                stack.push(mx);
            }
        }
        return stack.size();
    }
}
