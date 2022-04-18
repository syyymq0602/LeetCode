package offer.special;

import java.util.Arrays;
import java.util.Stack;

/**
 * 剑指 Offer II 037. 小行星碰撞
 *
 * 给定一个整数数组 asteroids，表示在同一行的小行星。
 *
 * 对于数组中的每一个元素，其绝对值表示小行星的大小，正负表示小行星的移动方向（正表示向右移动，负表示向左移动）。每一颗小行星以相同的速度移动。
 * 找出碰撞后剩下的所有小行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，
 * 则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞
 *
 * 2 <= asteroids.length <= 10e4
 * -1000 <= asteroids[i] <= 1000
 * asteroids[i] != 0
 */
public class O037 {
    public static void main(String[] args) {
        var ans = asteroidCollision(new int[]{-2,-2,1,-2});
        System.out.println(Arrays.toString(ans));
    }

    private static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack();
        for (int ast: asteroids) {
            collision: {
                while (!stack.isEmpty() && ast < 0 && 0 < stack.peek()) {
                    if (stack.peek() < -ast) {
                        stack.pop();
                        continue;
                    } else if (stack.peek() == -ast) {
                        stack.pop();
                    }
                    break collision;
                }
                stack.push(ast);
            }
        }

        int[] ans = new int[stack.size()];
        for (int t = ans.length - 1; t >= 0; --t) {
            ans[t] = stack.pop();
        }
        return ans;
    }
}
