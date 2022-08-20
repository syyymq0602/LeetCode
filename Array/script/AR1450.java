package Array.script;

/**
 * 1450. 在既定时间做作业的学生人数
 *
 * 给你两个整数数组 startTime（开始时间）和 endTime（结束时间），并指定一个整数 queryTime 作为查询时间。
 * 已知，第 i 名学生在 startTime[i] 时开始写作业并于 endTime[i] 时完成作业。
 * 请返回在查询时间 queryTime 时正在做作业的学生人数。形式上，返回能够使 queryTime 处于区间 [startTime[i], endTime[i]]（含）的学生人数。
 *
 * startTime.length == endTime.length
 * 1 <= startTime.length <= 100
 * 1 <= startTime[i] <= endTime[i] <= 1000
 * 1 <=queryTime <= 1000
 */
public class AR1450 {
    public static void main(String[] args) {
        System.out.println(busyStudent(new int[]{1,2,3},new int[]{3,2,7},4));
    }

    private static int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        for (int i = 0; i < startTime.length; i++) {
            if(startTime[i] <= queryTime && endTime[i]>=queryTime){
                ++count;
            }
        }
        return count;
    }
}
