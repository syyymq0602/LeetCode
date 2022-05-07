package offer.special;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剑指 Offer II 074. 合并区间
 *
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间
 *
 * 1 <= intervals.length <= 10e4
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 10e4
 */
public class O074 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(merge(new int[][]{
                new int[]{2, 3},
                new int[]{4, 5},
                new int[]{6, 7},
                new int[]{8, 9},
                new int[]{1, 10}
        })));
    }

    private static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,((o1, o2) -> o1[0] - o2[0]));
        int n = intervals.length;
        List<int []> temp = new ArrayList<>();
        int[] cur = intervals[0];
        for (int i = 1; i < n; i++) {
            if(cur[1] < intervals[i][0]){
                temp.add(cur);
                cur = intervals[i];
            }else {
                cur[1] = Math.max(intervals[i][1],cur[1]);
            }
        }
        temp.add(cur);
        int[][] ans = new int[temp.size()][];
        for (int i = 0; i < temp.size(); i++) {
            ans[i] = temp.get(i);
        }
        return ans;
    }
}
