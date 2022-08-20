package Stack.array;

import java.util.Arrays;
import java.util.Stack;

/**
 * 739. 每日温度
 *
 * 给定一个整数数组temperatures，表示每天的温度，返回一个数组answer，其中answer[i]是指对于第 i 天，
 * 下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用0 来代替
 *
 * 1 <= temperatures.length <= 10e5
 * 30 <= temperatures[i] <= 100
 */
public class S739 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})));
    }

    private static int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        if(len == 1){
            return new int[]{0};
        }
        int[] ans = new int[len];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < len; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                int top = stack.pop();
                ans[top] = i - top;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            ans[stack.pop()] = 0;
        }
        return ans;
    }
}
