package Array.script;

import java.util.Arrays;

/**
 * 75. 颜色分类
 *
 * 给定一个包含红色、白色和蓝色、共n 个元素的数组nums，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库的sort函数的情况下解决这个问题
 *
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] 为 0、1 或 2
 */
public class AR75 {
    public static void main(String[] args) {
        var nums = new int[]{2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0,p1 = 0;
        for (int i = 0; i < n; i++) {
            if(nums[i] == 1){
                swap(nums,i,p1);
                ++p1;
            }else if(nums[i] == 0){
                swap(nums,i,p0);
                if(p0 < p1){
                    swap(nums,i,p1);
                }
                ++p1;
                ++p0;
            }
        }
    }

    private static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
