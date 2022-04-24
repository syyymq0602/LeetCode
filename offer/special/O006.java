package offer.special;

import java.util.Arrays;

/**
 * 剑指 Offer II 006. 排序数组中两个数字之和
 *
 * 给定一个已按照 升序排列的整数数组numbers ，请你从数组中找出两个数满足相加之和等于目标数target 。
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 0开始计数 ，所以答案数组应当满足 0<= answer[0] < answer[1] <numbers.length。
 * 假设数组中存在且只存在一对符合条件的数字，同时一个数字不能使用两次
 *
 * 2 <= numbers.length <= 3 * 104
 * -1000 <= numbers[i] <= 1000
 * numbers 按 递增顺序 排列
 * -1000 <= target <= 1000
 * 仅存在一个有效答案
 */
public class O006 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{1,2,4,6,10},8)));
    }

    private static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        while (left <= right){
            if(numbers[left] + numbers[right] > target){
                right--;
            }else if(numbers[left] + numbers[right] < target){
                left++;
            }else {
                break;
            }
        }
        return new int[]{left,right};
    }
}
