package offer.scripts;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 剑指 Offer 30. 包含min函数的栈
 * <p>
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * <p>
 * 各函数的调用总次数不超过 20000 次
 */
public class o30 {
    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-1);
        obj.pop();
        var res = obj.min();
        obj.pop();
        var top =obj.top();
        var ss =obj.min();
        System.out.println(res);
    }

    private static class MinStack {

        LinkedList<Integer> linkedList;
        LinkedList<Integer> stack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            linkedList = new LinkedList<>();
            stack = new LinkedList<>();
        }

        public void push(int x) {
            if(!linkedList.isEmpty()){
                int minNum = Math.min(x, stack.peek());
                stack.push(minNum);
            }else {
                stack.push(x);
            }
            linkedList.offerLast(x);
        }

        public void pop() {
            linkedList.pollLast();
            stack.pop();
        }

        public int top() {
            if(!linkedList.isEmpty()){
                return linkedList.peekLast();
            }
            return -1;
        }

        public int min() {
            return stack.peek();
        }
    }
}
