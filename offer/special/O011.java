package offer.special;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 011. 0 和 1 个数相同的子数组
 * <p>
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度
 * <p>
 * 1 <= nums.length <= 10e5
 * nums[i] 不是 0 就是 1
 */
public class O011 {
    public static void main(String[] args) {
        System.out.println(findMaxLength(new int[]{0, 0, 1, 0, 0, 0, 1, 1}));
    }

    private static int findMaxLength(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int len = 0;
        int count = 0;
        map.put(0, -1);
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num == 1) {
                count++;
            } else {
                count--;
            }
            if (map.containsKey(count)) {
                int pre = map.get(count);
                len = Math.max(len, i - pre);
            } else {
                map.put(count, i);
            }
        }
        return len;
    }
}
