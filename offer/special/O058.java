package offer.special;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer II 058. 日程表
 *
 * 请实现一个 MyCalendar 类来存放你的日程安排。如果要添加的时间内没有其他安排，则可以存储这个新的日程安排。
 * MyCalendar 有一个 book(int start, int end)方法。它意味着在 start 到 end 时间内增加一个日程安排，注意，这里的时间是半开区间，
 * 即 [start, end), 实数x 的范围为， start <= x < end。
 * 当两个日程安排有一些时间上的交叉时（例如两个日程安排都在同一时间内），就会产生重复预订。
 * 每次调用 MyCalendar.book方法时，如果可以将日程安排成功添加到日历中而不会导致重复预订，返回 true。
 * 否则，返回 false并且不要将该日程安排添加到日历中。
 *
 * 每个测试用例，调用 MyCalendar.book 函数最多不超过 1000次。
 * 0 <= start < end <= 10e9
 */
public class O058 {
    public static void main(String[] args) {
        var cal = new MyCalendar();
        System.out.println(cal.book(10,20));
        System.out.println(cal.book(15,25));
        System.out.println(cal.book(20,30));
    }

    private static class MyCalendar {
        List<int[]> list;
        public MyCalendar() {
            list = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            for (int[] item:list) {
                if(start < item[1] && end > item[0]){
                    return false;
                }
            }
            list.add(new int[]{start,end});
            return true;
        }
    }
}
