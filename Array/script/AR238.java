package Array.script;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 238. 除自身以外数组的乘积
 * <p>
 * 给你一个整数数组nums，返回 数组answer，其中answer[i]等于nums中除nums[i]之外其余各元素的乘积。
 * 题目数据 保证 数组nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内。
 * 请不要使用除法，且在O(n) 时间复杂度内完成此题。
 * <p>
 * 2 <= nums.length <= 10e5
 * -30 <= nums[i] <= 30
 * 保证 数组nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内
 */
public class AR238 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1,1,0,-3,3})));
    }

    private static int[] productExceptSelf(int[] nums) {
        Map<Integer, Integer> pre = new HashMap<>();
        Map<Integer, Integer> next = new HashMap<>();
        int preCount = 1;
        int nextCount = 1;
        int n = nums.length;
        pre.put(0, 1);
        next.put(n - 1, 1);
        for (int i = 0; i < n; i++) {
            pre.put(i, preCount);
            next.put(i, nextCount);
            preCount *= nums[i];
            nextCount *= nums[n - i - 1];
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = pre.get(i) * next.get(n-i-1);
        }
        return ans;
    }
}
