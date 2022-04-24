package offer.special;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 010. 和为 k 的子数组
 * <p>
 * 给定一个整数数组和一个整数 k ，请找到该数组中和为 k 的连续子数组的个数
 * <p>
 * 1 <= nums.length <= 2 * 10e4
 * -1000 <= nums[i] <= 1000
 * -10e7 <= k <= 10e7
 */
public class O010 {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{-1, -1, 1}, 0));
    }

    private static int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        int pre = 0, count = 0;
        map.put(0,1);
        for (int i = 0; i < n; i++) {
            pre += nums[i];
            if(map.containsKey(pre - k)){
                count += map.get(pre - k);
            }
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return count;
    }
}
