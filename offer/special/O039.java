package offer.special;


import java.util.Arrays;
import java.util.LinkedList;

/**
 * 剑指 Offer II 039. 直方图最大矩形面积
 * <p>
 * 给定非负整数数组 heights，数组中的数字用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积
 * <p>
 * 1 <= heights.length <=10e5
 * 0 <= heights[i] <= 10e4
 */
public class O039 {
    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{6,7,5,2,4,5,9,3}));
    }

    private static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                right[stack.peek()] = i;
                stack.pop();
            }
            left[i] = (stack.isEmpty() ? -1 : stack.peek());
            stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }
}
