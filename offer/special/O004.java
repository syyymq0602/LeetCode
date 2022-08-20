package offer.special;

import java.util.Hashtable;
import java.util.Map;

/**
 * 剑指 Offer II 004. 只出现一次的数字
 *
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素
 *
 * 1 <= nums.length <= 3 * 10e4
 * -2e31 <= nums[i] <= 2e31 - 1
 * nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次
 */
public class O004 {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{0,1,0,1,0,1,100}));
    }

    private static int singleNumber(int[] nums) {
        int ans = 0;
        Map<Integer,Integer> map = new Hashtable<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1){
                ans = entry.getKey();
                break;
            }
        }
        return ans;
    }
}
