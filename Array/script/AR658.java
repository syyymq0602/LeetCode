package Array.script;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 658. 找到 K 个最接近的元素
 *
 * 给定一个 排序好 的数组arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
 * 整数 a 比整数 b 更接近 x 需要满足：
 * |a - x| < |b - x| 或者
 * |a - x| == |b - x| 且 a < b
 *
 * 1 <= k <= arr.length
 * 1 <= arr.length<= 10e4
 * arr按 升序 排列
 * -10e4<= arr[i], x <= 10e4
 */
public class AR658 {
    public static void main(String[] args) {
        System.out.println(findClosestElements(new int[]{0,0,1,2,3,3,4,7,7,8},3,5).toString());
    }

    private static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }
        Collections.sort(list, (a, b) -> {
            if (Math.abs(a - x) != Math.abs(b - x)) {
                return Math.abs(a - x) - Math.abs(b - x);
            } else {
                return a - b;
            }
        });
        List<Integer> ans = list.subList(0, k);
        Collections.sort(ans);
        return ans;
    }
}
