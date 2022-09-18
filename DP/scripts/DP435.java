package DP.scripts;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 435. 无重叠区间
 *
 * 给定一个区间的集合intervals，其中 intervals[i] = [starti, endi]。返回 需要移除区间的最小数量，使剩余区间互不重叠。
 *
 * 1 <= intervals.length <= 10e5
 * intervals[i].length == 2
 * -5 * 10e4<= starti< endi<= 5 * 10e4
 */
public class DP435 {
    public static void main(String[] args) {
        var intervals = new int[][]{
                {1,2},{2,3},{3,4},{1,3}
        };
        System.out.println(eraseOverlapIntervals(intervals));
    }

    private static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (interval1, interval2) -> interval1[0] - interval2[0]);

        int n = intervals.length;
        int[] f = new int[n];
        Arrays.fill(f, 1);
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (intervals[j][1] <= intervals[i][0]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }
        return n - Arrays.stream(f).max().getAsInt();
    }
}
