package Array.script;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为 K 的子数组
 *
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数
 *
 * 1 <= nums.length <= 2 * 10e4
 * -1000 <= nums[i] <= 1000
 * -10e7 <= k <= 10e7
 */
public class AR560 {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,1,1},2));
    }

    private static int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if(map.containsKey(pre - k)){
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre,0)+1);
        }
        return count;
    }
}
