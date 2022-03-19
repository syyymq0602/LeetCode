package Array.script;

/**
 * 31. 下一个排列
 *
 * 整数数组的一个 排列 就是将其所有成员以序列或线性顺序排列。
 *
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1]、[2,1,3]、[3,2,1] 。
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 *
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 */
public class AR31 {
    public static void main(String[] args) {
        var nums = new int[]{1,2,3,8,6,7,5,4};
        nextPermutation(nums);
        var res = "";
        for (int i = 0; i < nums.length; i++) {
            res += nums[i] + " ";
        }
        System.out.println(res);
    }

    private static void nextPermutation(int[] nums) {
        int n = nums.length;
        int index = n-1;
        while (index > 0 && nums[index-1] >= nums[index]){
            index--;
        }
        if(index > 0){
            int j = n-1;
            while (j>0 && nums[j] <= nums[index-1]){
                j--;
            }
            swap(nums,index-1,j);
        }
        reverse(nums,index,n-1);
    }

    private static void reverse(int[] nums,int start,int end){
        while (start < end){
            swap(nums,start,end);
            start++;
            end--;
        }
    }

    private static void swap(int[] nums,int start,int end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}
