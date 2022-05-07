package Sort;

import java.util.Arrays;


public class Sorts {
    public static void main(String[] args) {
        var num1 = new int[]{3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
        var num2 = new int[]{3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
        var num3 = new int[]{3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
        var num4 = new int[]{3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
        BuddleSort(num1);
        SelectSort(num2);
        insertSort(num3);
    }

    /**
     * 冒泡排序
     *
     * 通过每一次遍历获取最大/最小值
     * 将最大值/最小值放在尾部/头部
     * 然后除开最大值/最小值，剩下的数据在进行遍历获取最大/最小值
     *
     * @param nums 待排序数组
     */
    public static void BuddleSort(int[] nums){
        int n = nums.length;
        if(n == 0){
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if(nums[j] > nums[j+1]){
                    swap(nums,j,j+1);
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 选择排序
     *
     * 将第一个值看成最小值
     * 然后和后续的比较找出最小值和下标
     * 交换本次遍历的起始值和最小值
     * 每次遍历的时候，将前面找出的最小值，看成一个有序的列表，后面的看成无序的列表，然后每次遍历无序列表找出最小值
     *
     * @param nums 待排序数组
     */
    public static void SelectSort(int[] nums){
        int n = nums.length;
        if(n == 0){
            return;
        }
        for (int i = 0; i < n; i++) {
            int min = nums[i];
            int index = i;
            for (int j = i+1; j < n; j++) {
                if(min > nums[j]){
                    min = nums[j];
                    index = j;
                }
            }
            swap(nums,i,index);
        }
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 插入排序
     *
     * 默认从第二个数据开始比较。
     * 如果第二个数据比第一个小，则交换。然后在用第三个数据比较，如果比前面小，则插入（狡猾）。否则，退出循环
     * 默认将第一数据看成有序列表，后面无序的列表循环每一个数据，如果比前面的数据小则插入（交换）。否则退出
     *
     * @param nums 待排序数组
     */
    public static void insertSort(int[] nums){
        int n = nums.length;
        if(n == 0){
            return;
        }
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 ; j--) {
                if(nums[j] < nums[j-1]){
                    swap(nums,j,j-1);
                }else {
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    private static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
