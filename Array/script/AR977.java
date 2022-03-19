package Array.script;

import java.util.Arrays;

/**
 * 977. 有序数组的平方
 *
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 已按 非递减顺序 排序
 */
public class AR977 {

    public static void main(String[] args) {
        var nums = new int[]{-4,-1,0,3,10};
        var res = sortedSquares1(nums);
        var out = "";
        for (var item:res) {
            out += item + " ";
        }
        System.out.println(out);
    }

    private static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = nums[i] * nums[i];
        }
        Arrays.sort(ans);
        return ans;
    }

    private static int[] sortedSquares1(int[] nums){
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0,j=n-1,pos=n-1; i <=j ;) {
            if(nums[i] * nums[i] > nums[j]*nums[j]){
                ans[pos] = nums[i] * nums[i];
                ++i;
            }else {
                ans[pos] = nums[j] * nums[j];
                --j;
            }
            --pos;
        }
        return ans;
    }
}
