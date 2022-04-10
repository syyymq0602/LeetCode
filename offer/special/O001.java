package offer.special;

/**
 * 剑指 Offer II 001. 整数除法
 * <p>
 * 给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%'
 * <p>
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8以及truncate(-2.7335) = -2
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2e31,2e31−1]。本题中，如果除法结果溢出，则返回 2e31− 1
 * <p>
 * -2e31 <= a, b <= 2e31 - 1
 * b != 0
 */
public class O001 {
    public static void main(String[] args) {
        int b = 65;
        System.out.println(b << 1);
        System.out.println(b << 2);
        System.out.println(divide(9, -2));
    }

    private static int divide(int a, int b) {
        if ((a == Integer.MIN_VALUE && b == -1) || (a == Integer.MAX_VALUE && b == 1)) {
            return Integer.MAX_VALUE;
        }
        if (a == Integer.MIN_VALUE && b == 1) {
            return Integer.MIN_VALUE;
        }
        if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
            return 1;
        }
        if (b == Integer.MIN_VALUE) {
            return 0;
        }
        boolean flag = (a ^ b) >= 0;
        int res = 0;
        b = b < 0 ? -b : b;
        if (a == Integer.MIN_VALUE) {
            a += b;
            res++;
        }
        a = a < 0 ? -a : a;
        if (a < b) {
            return flag ? res : -res;
        }
        for (int i = 30; i >= 0; i--) {
            if (b > (Integer.MAX_VALUE >> i)) {
                continue;
            }
            int curDiv = b << i;
            if (a >= curDiv) {
                a -= curDiv;
                if (res > Integer.MAX_VALUE - (1 << i)) {
                    return Integer.MIN_VALUE;
                }
                res += 1 << i;
            }
        }
        return flag ? res : -res;
    }
}
