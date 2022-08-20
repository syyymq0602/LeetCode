package Array.script;

import java.util.*;

/**
 * 1331. 数组序号转换
 *
 * 给你一个整数数组arr ，请你将数组中的每个元素替换为它们排序后的序号。
 * 序号代表了一个元素有多大。序号编号的规则如下：
 * 序号从 1 开始编号。
 * 一个元素越大，那么序号越大。如果两个元素相等，那么它们的序号相同。
 * 每个数字的序号都应该尽可能地小。
 *
 * 0 <= arr.length <= 10e5
 * -10e9 <= arr[i] <= 10e9
 */
public class AR1331 {
    public static void main(String[] args) {
        var arr = new int[]{40,10,20,30};
        System.out.println(Arrays.toString(arrayRankTransform(arr)));
    }

    private static int[] arrayRankTransform(int[] arr) {
        int len = arr.length;
        if(len == 0){
            return new int[]{};
        }
        int[] temp = Arrays.copyOf(arr,len);
        Arrays.sort(arr);
        int order = 1;
        Map<Integer,Integer> set = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if(set.containsKey(arr[i])){
                continue;
            }
            set.put(arr[i], order);
            ++order;
        }
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = set.get(temp[i]);
        }
        return ans;
    }
}
