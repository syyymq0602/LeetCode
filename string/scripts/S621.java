package string.scripts;

import java.util.Arrays;

/**
 * 621. 任务调度器
 *
 * 给你一个用字符数组tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。
 * 任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。
 * 然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 * 你需要计算完成所有任务所需要的 最短时间 。
 *
 * 1 <= task.length <= 10e4
 * tasks[i] 是大写英文字母
 * n 的取值范围为 [0, 100]
 */
public class S621 {
    public static void main(String[] args) {
        System.out.println(leastInterval(new char[]{
                'A','A','A'
        },2));
    }

    private static int leastInterval(char[] tasks, int n) {
        //统计每个任务出现的次数，找到出现次数最多的任务
        int[] hash = new int[26];
        for(int i = 0; i < tasks.length; ++i) {
            hash[tasks[i] - 'A'] += 1;
        }
        Arrays.sort(hash);
        //因为相同元素必须有n个冷却时间，假设A出现3次，n = 2，任务要执行完，至少形成AXX AXX A序列（X看作预占位置）
        //该序列长度为
        int minLen = (n+1) *  (hash[25] - 1) + 1;

        //此时为了尽量利用X所预占的空间（贪心）使得整个执行序列长度尽量小，将剩余任务往X预占的空间插入
        //剩余的任务次数有两种情况：
        //1.与A出现次数相同，比如B任务最优插入结果是ABX ABX AB，中间还剩两个空位，当前序列长度+1
        //2.比A出现次数少，若还有X，则按序插入X位置，比如C出现两次，形成ABC ABC AB的序列
        //直到X预占位置还没插满，剩余元素逐个放入X位置就满足冷却时间至少为n
        for(int i = 24; i >= 0; --i){
            if(hash[i] == hash[25]) ++ minLen;
        }
        //当所有X预占的位置插满了怎么办？
        //在任意插满区间（这里是ABC）后面按序插入剩余元素，比如ABCD ABCD发现D之间距离至少为n+1，肯定满足冷却条件
        //因此，当X预占位置能插满时，最短序列长度就是task.length，不能插满则取最少预占序列长度
        return Math.max(minLen, tasks.length);
    }
}
