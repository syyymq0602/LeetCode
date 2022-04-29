package offer.special;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 057. 值和下标之差都在给定的范围内
 *
 * 给你一个整数数组 nums 和两个整数k 和 t 。请你判断是否存在 两个不同下标 i 和 j，
 * 使得abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
 * 如果存在则返回 true，不存在返回 false
 *
 * 0 <= nums.length <= 2 * 10e4
 * -2e31 <= nums[i] <= 2e31 - 1
 * 0 <= k <= 10e4
 * 0 <= t <= 2e31 - 1
 */
public class O057 {
    public static void main(String[] args) {
        var nums = new int[]{1,2,3,1};
        System.out.println(containsNearbyAlmostDuplicate(nums,3,0));
    }

    private static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        Map<Long, Long> map = new HashMap<>();
        long w = (long) t + 1;
        for (int i = 0; i < n; i++) {
            long id = getID(nums[i], w);
            if (map.containsKey(id)) {
                return true;
            }
            if (map.containsKey(id - 1) && Math.abs(nums[i] - map.get(id - 1)) < w) {
                return true;
            }
            if (map.containsKey(id + 1) && Math.abs(nums[i] - map.get(id + 1)) < w) {
                return true;
            }
            map.put(id, (long) nums[i]);
            if (i >= k) {
                map.remove(getID(nums[i - k], w));
            }
        }
        return false;
    }

    public static long getID(long x, long w) {
        if (x >= 0) {
            return x / w;
        }
        return (x + 1) / w - 1;
    }
}
