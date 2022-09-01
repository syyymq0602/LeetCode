package Sort;

import java.util.Arrays;


public class Sorts {
    public static void main(String[] args) {
        var num1 = new int[]{3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        var num2 = new int[]{3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        var num3 = new int[]{3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        var num4 = new int[]{3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        var num5 = new int[]{3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 47, 19, 50, 48};
        var num6 = new int[]{3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 47, 19, 50, 48};
        var num7 = new int[]{3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 47, 19, 50, 48};
        var num8 = new int[]{3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 47, 19, 50, 48};
//        BuddleSort(num1);
//        SelectSort(num2);
//        insertSort(num3);
//        mergeSort(num4, 0, num4.length - 1);
//        System.out.println(Arrays.toString(num4));
//        quickSort(num5,0,num5.length-1);
//        System.out.println(Arrays.toString(num5));
//        shellSort(num6);
//        heapSort(num7);
        bucketSort(num8);
    }

    /**
     * 归并排序
     * <p>
     * 由递归实现的，主要是分而治之的思想，也就是通过将问题分解成多个容易求解的局部性小问题来解开原本的问题的技巧。
     * 将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为二路归并。
     * 每次分别排左半边和右半边，不断递归调用自己，直到只有一个元素递归结束，开始回溯，调用 merge 函数，
     * 合并两个有序序列，再合并的时候每次给末尾追上一个最大 int 这样就不怕最后一位的数字不会被排序。
     *
     * @param arr   待排序数组
     * @param start 起始下标
     * @param end   终止下标
     */
    private static void mergeSort(int[] arr, int start, int end) {
        //判断拆分的不为最小单位
        if (end - start > 0) {
            //再一次拆分，知道拆成一个一个的数据
            mergeSort(arr, start, (start + end) / 2);
            mergeSort(arr, (start + end) / 2 + 1, end);
            //记录开始/结束位置
            int left = start;
            int right = (start + end) / 2 + 1;
            //记录每个小单位的排序结果
            int index = 0;
            int[] result = new int[end - start + 1];
            //如果查分后的两块数据，都还存在
            while (left <= (start + end) / 2 && right <= end) {
                //比较两块数据的大小，然后赋值，并且移动下标
                if (arr[left] <= arr[right]) {
                    result[index] = arr[left];
                    left++;
                } else {
                    result[index] = arr[right];
                    right++;
                }
                //移动单位记录的下标
                index++;
            }
            //当某一块数据不存在了时
            while (left <= (start + end) / 2 || right <= end) {
                //直接赋值到记录下标
                if (left <= (start + end) / 2) {
                    result[index] = arr[left];
                    left++;
                } else {
                    result[index] = arr[right];
                    right++;
                }
                index++;
            }
            //最后将新的数据赋值给原来的列表，并且是对应分块后的下标。
            for (int i = start; i <= end; i++) {
                arr[i] = result[i - start];
            }
        }
    }

    /**
     * 快速排序
     * <p>
     * 一种比较高效的排序算法，采用“分而治之”的思想，通过多次比较和交换来实现排序，
     * 在一趟排序中把将要排序的数据分成两个独立的部分，对这两部分进行排序使得其中一部分所有数据比另一部分都要小，
     * 然后继续递归排序这两部分，最终实现所有数据有序。
     *
     * @param arr   待排序数组
     * @param left  起始下标
     * @param right 终止下标
     */
    public static void quickSort(int[] arr, int left, int right) {
        //运行判断，如果左边索引大于右边是不合法的，直接return结束次方法
        if (left >= right) {
            return;
        }
        //定义变量保存基准数
        int base = arr[left];
        //定义变量i，指向最左边
        int i = left;
        //定义j ,指向最右边
        int j = right;
        //当i和j不相遇的时候，再循环中进行检索
        while (i != j) {
            //先由j从右往左检索比基准数小的，如果检索到比基准数小的就停下。
            //如果检索到比基准数大的或者相等的就停下
            while (arr[j] >= base && i < j) {
                j--; //j从右往左检索
            }
            while (arr[i] <= base && i < j) {
                i++; //i从左往右检索
            }
            //代码走到这里i停下，j也停下，然后交换i和j位置的元素
            swap(arr, i, j);
        }
        //如果上面while条件不成立就会跳出这个循环，往下执行
        //如果这个条件不成立就说明 i和j相遇了
        //如果i和j相遇了，就交换基准数这个元素和相遇位置的元素
        //把相遇元素的值赋给基准数这个位置的元素
        arr[left] = arr[i];
        //把基准数赋给相遇位置的元素
        arr[i] = base;
        //基准数在这里递归就为了左边的数比它小，右边的数比它大
        //排序基准数的左边
        quickSort(arr, left, i - 1);
        //排右边
        quickSort(arr, j + 1, right);
    }

    /**
     * 桶排序
     *
     * 原理是将数组分到有限数量的桶子里。每个桶子再个别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排序）。
     * 桶排序是鸽巢排序的一种归纳结果。当要被排序的数组内的数值是均匀分配的时候，
     * 桶排序使用线性时间（Θ（n））。但桶排序并不是比较排序，他不受到 O(n log n) 下限的影响。
     *
     * 1. 遍历原始数组，找到数组中的最大值
     * 2. 创建一个下标为原始数组中最大值的桶数组,该桶数组的下标代表元素，该数组下标所对应的值代表这个值出现的次数
     * 3. 再次遍历原始数组，得到原数组中存在的各个元素，以及出现的次数
     * 4. 遍历桶数组,外层循环从桶的第一位开始（即下表为零）；内层循环遍历桶数组中下标为i的值出现的次数
     *
     * @param arr 待排序数组
     */
    public static void bucketSort(int[] arr) {
        // 遍历原始数组，找到数组中的最大值
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        // 创建一个下标为原始数组中最大值的桶数组,该桶数组的下标代表元素，该数组下标所对应的值代表这个值出现的次数
        int[] bucketArray = new int[max + 1];
        // 再次遍历原始数组，得到原数组中存在的各个元素，以及出现的次数
        for (int i = 0; i < arr.length; i++) {
            bucketArray[arr[i]]++;
        }
        // 遍历桶数组,外层循环从桶的第一位开始（即下表为零）；内层循环遍历桶数组中下标为i的值出现的次数
        int index = 0;
        for (int i = 0; i < bucketArray.length; i++) {
            for (int j = 0; j < bucketArray[i]; j++) {
                arr[index++] = i;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 堆排序
     *
     * @param arr 待排序数组
     */
    public static void heapSort(int[] arr) {
        int n = arr.length;
        int i;
        // 从(n/2-1) --> 0逐次遍历。遍历之后，得到的数组实际上是一个(最大)二叉堆。
        for (i = n / 2 - 1; i >= 0; i--)
            maxHeapDown(arr, i, n - 1);
        // 从最后一个元素开始对序列进行调整，不断的缩小调整的范围直到第一个元素
        for (i = n - 1; i >= 0; i--) {
            // 交换a[0]和a[i]。交换后，a[i]是a[0...i]中最大的。
            swap(arr, 0, i);
            // 调整a[0...i-1]，使得a[0...i-1]仍然是一个最大堆。
            // 即，保证a[i-1]是a[0...i-1]中的最大值。
            maxHeapDown(arr, 0, i);
        }
        System.out.println(Arrays.toString(arr));
    }

    /*
     * 注：数组实现的堆中，第N个节点的左孩子的索引值是(2N+1)，右孩子的索引是(2N+2)。
     *     其中，N为数组下标索引值，如数组中第1个数对应的N为0。
     *
     * 参数说明：
     *     arr -- 待排序的数组
     *     index -- 被下调节点的起始位置(一般为0，表示从第1个开始)
     *     length   -- 截至范围(一般为数组中最后一个元素的索引)
     */
    private static void maxHeapDown(int[] arr, int index, int length) {
        for (int left = 2 * index + 1; left < length; left = 2 * index + 1) {
            //右子节点
            int right = left + 1;
            //比较左右子节点哪个比较大  就换哪个
            if (right < length && arr[right] > arr[left]) {
                left = right;
            }
            //此时left指向当前节点左右子节点较大的那个节点
            if (arr[left] > arr[index]) {
                swap(arr, left, index);
                index = left; //这次变换可能会导致该子节点不满足大小顶堆的要求，因此index要转向该子节点继续调整
            } else {
                break;
            }
        }
    }

    /**
     * 将一个数组（二叉树）调整成一个大根堆
     * 功能：完成将以i对应的非叶子结点的树调整成大顶堆
     * 举例int arr[]={4,6,8,5,9};=>i=1=> adjustHeap=>得到{4,9,8,5,6}
     * 如果我们再次调用adjustHeap 传入的是i=0=>得到{4,9,8,5,6}=> {9,6,8,5,4}
     *
     * @param arr    待调整的数组
     * @param i      表示非叶子结点在数组中索引
     * @param length 表示对多少个元素继续调整，length 是在逐渐的减少
     */
    public static void adjustHeap(int arr[], int i, int length) {
        int temp = arr[i];//先取出当前元素的值，保存在临时变量
        //开始调整.
        //说明:k=i*2+1k是i结点的左子结点
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > arr[i]) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }

    /**
     * 冒泡排序
     * <p>
     * 通过每一次遍历获取最大/最小值
     * 将最大值/最小值放在尾部/头部
     * 然后除开最大值/最小值，剩下的数据在进行遍历获取最大/最小值
     *
     * @param nums 待排序数组
     */
    public static void BuddleSort(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 选择排序
     * <p>
     * 将第一个值看成最小值
     * 然后和后续的比较找出最小值和下标
     * 交换本次遍历的起始值和最小值
     * 每次遍历的时候，将前面找出的最小值，看成一个有序的列表，后面的看成无序的列表，然后每次遍历无序列表找出最小值
     *
     * @param nums 待排序数组
     */
    public static void SelectSort(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return;
        }
        for (int i = 0; i < n; i++) {
            int min = nums[i];
            int index = i;
            for (int j = i + 1; j < n; j++) {
                if (min > nums[j]) {
                    min = nums[j];
                    index = j;
                }
            }
            swap(nums, i, index);
        }
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 插入排序
     * <p>
     * 默认从第二个数据开始比较。
     * 如果第二个数据比第一个小，则交换。然后在用第三个数据比较，如果比前面小，则插入（狡猾）。否则，退出循环
     * 默认将第一数据看成有序列表，后面无序的列表循环每一个数据，如果比前面的数据小则插入（交换）。否则退出
     *
     * @param nums 待排序数组
     */
    public static void insertSort(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return;
        }
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                } else {
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 希尔排序
     * <p>
     * 希尔排序(Shell’s Sort)是插入排序的一种，又称“缩小增量排序”，是直接插入排序算法的一种更高效的改进版本。
     * 希尔排序是把待排序序列按下标的一定增量分组，对每组使用直接插入排序算法排序；
     * 随着增量逐渐减少，每组包含的元素越来越多，当增量减至 1 时，整个序列恰被分成一组，排序完成。
     *
     * @param array 待排序数组
     */
    public static void shellSort(int[] array) {
        int len = array.length;
        for (int gap = len >> 1; gap > 0; gap = gap >> 1) {
            for (int i = gap; i < len; i++) {
                for (int j = i; j > gap - 1; j = j - gap) {
                    //使当前元素找到属于自己的位置
                    if (array[j] < array[j - gap]) {
                        swap(array, j, j - gap);
                    }
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
