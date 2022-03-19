package Array.script;

import java.util.*;

/**
 * 350. 两个数组的交集 II
 *
 * 给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，
 * 应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 *
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 */
public class AR350 {
    public static void main(String[] args) {
        var num1 = new int[]{4,9,5,8};
        var num2 = new int[]{9,4,9,9,8,4};
        int[] intersect = intersect(num1, num2);
        var out = "";
        for (var item :intersect) {
            out += item +" ";
        }
        System.out.println(out);
    }

    private static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(nums1[0] > nums2[n2-1] || nums2[0] > nums1[n1-1]){
            return new int[]{};
        }
        Queue<Integer> queue = new LinkedList<>();
        int index1 = 0,index2 = 0;
        while (index1 < n1 && index2<n2){
            if(nums1[index1] < nums2[index2]){
                index1++;
            }else if(nums1[index1] > nums2[index2]){
                index2++;
            }else {
                queue.offer(nums1[index1]);
                index1++;
                index2++;
            }
        }
        int size = queue.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = queue.poll();
        }
        return res;
    }
}
