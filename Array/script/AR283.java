package Array.script;

/**
 * 283. 移动零
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 */
public class AR283 {
    public static void main(String[] args) {
        var nums = new int[]{1,0,2};
        moveZeroes(nums);
        var out = "";
        for (var item:nums) {
            out += item + " ";
        }
        System.out.println(out);
    }

    private static void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        while (right != nums.length){
            if(nums[right] != 0 ){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
    }
}
