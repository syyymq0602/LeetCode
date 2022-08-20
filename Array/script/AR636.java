package Array.script;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * 636. 函数的独占时间
 *
 * 有一个 单线程 CPU 正在运行一个含有 n 道函数的程序。每道函数都有一个位于 0 和 n-1 之间的唯一标识符。
 * 函数调用 存储在一个 调用栈 上 ：当一个函数调用开始时，它的标识符将会推入栈中。而当一个函数调用结束时，
 * 它的标识符将会从栈中弹出。标识符位于栈顶的函数是 当前正在执行的函数 。每当一个函数开始或者结束时，
 * 将会记录一条日志，包括函数标识符、是开始还是结束、以及相应的时间戳。
 * 给你一个由日志组成的列表 logs ，其中 logs[i] 表示第 i 条日志消息，该消息是一个按 "{function_id}:{"start" | "end"}:{timestamp}"
 * 进行格式化的字符串。例如，"0:start:3" 意味着标识符为 0 的函数调用在时间戳 3 的 起始开始执行 ；
 * 而 "1:end:2" 意味着标识符为 1 的函数调用在时间戳 2 的 末尾结束执行。注意，函数可以 调用多次，可能存在递归调用 。
 * 函数的 独占时间 定义是在这个函数在程序所有函数调用中执行时间的总和，调用其他函数花费的时间不算该函数的独占时间。
 * 例如，如果一个函数被调用两次，一次调用执行 2 单位时间，另一次调用执行 1 单位时间，那么该函数的 独占时间 为 2 + 1 = 3 。
 * 以数组形式返回每个函数的 独占时间 ，其中第 i 个下标对应的值表示标识符 i 的函数的独占时间。
 *
 * 1 <= n <= 100
 * 1 <= logs.length <= 500
 * 0 <= function_id < n
 * 0 <= timestamp <= 10e9
 * 两个开始事件不会在同一时间戳发生
 * 两个结束事件不会在同一时间戳发生
 * 每道函数都有一个对应"start" 日志的 "end" 日志
 */
public class AR636 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(exclusiveTime(2,
                Arrays.asList("0:start:0","0:start:2","0:end:5","1:start:6","1:end:6","0:end:7"))));
    }

    private static int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        Deque<Integer> d = new ArrayDeque<>();
        int cur = -1;
        for (String log : logs) {
            String[] ss = log.split(":");
            int idx = Integer.parseInt(ss[0]), ts = Integer.parseInt(ss[2]);
            if (ss[1].equals("start")) {
                if (!d.isEmpty())
                    ans[d.peekLast()] += ts - cur;
                d.addLast(idx);
                cur = ts;
            } else {
                int func = d.pollLast();
                ans[func] += ts - cur + 1;
                cur = ts + 1;
            }
        }
        return ans;
    }
}
