package offer.special;

/**
 * 剑指 Offer II 072. 求平方根
 *
 * 给定一个非负整数 x ，计算并返回 x 的平方根，即实现int sqrt(int x)函数。
 * 正数的平方根有两个，只输出其中的正数平方根。
 * 如果平方根不是整数，输出只保留整数的部分，小数部分将被舍去
 *
 * 0 <= x <= 2e31 - 1
 */
public class O072 {
    public static void main(String[] args) {
        System.out.println(mySqrt(11));
    }

    private static int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long)mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
