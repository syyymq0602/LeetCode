package Array.script;

import java.util.Arrays;

/**
 * 169. 多数元素
 *
 * 给定一个大小为 n 的数组nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * n == nums.length
 * 1 <= n <= 5 * 10e4
 * -10e9 <= nums[i] <= 10e9
 */
public class AR169 {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3,2,3}));
    }

    private static int majorityElement(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int window = n / 2;
        int left = 0, right = window;
        int num = -1;
        while (right < n){
            if(nums[left] == nums[right]){
                num = nums[left];
                break;
            }
            ++left;
            ++right;
        }
        return num;
    }
}
