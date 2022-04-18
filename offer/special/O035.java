package offer.special;

import java.util.Arrays;
import java.util.List;

/**
 * 剑指 Offer II 035. 最小时间差
 *
 * 给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示
 *
 * 2 <= timePoints <= 2 * 10e4
 * timePoints[i] 格式为 "HH:MM"
 */
public class O035 {
    public static void main(String[] args) {
        System.out.println(findMinDifference(Arrays.asList("00:00","04:00","22:00")));
    }

    private static int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            String[] str = timePoints.get(i).split(":");
            int time = Integer.parseInt(str[0]) * 60 + Integer.parseInt(str[1]);
            times[i] =time;
        }
        int minAns = Integer.MAX_VALUE;
        Arrays.sort(times);
        for (int i = 0; i < n-1; i++) {
            int diff = Math.abs(times[i] - times[i+1]);
            int temp = Math.min(diff,1440 - diff);
            minAns = Math.min(minAns,temp);
        }
        int diff = Math.abs(times[n-1] - times[0]);
        int temp = Math.min(diff,1440 - diff);
        minAns = Math.min(minAns,temp);
        return minAns;

    }
}
