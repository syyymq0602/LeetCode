package offer.scripts;

/**
 * 剑指 Offer 10- I. 斐波那契数列
 *
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N),
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1
 *
 * 0 <= n <= 100
 */
public class o10 {
    public static void main(String[] args) {
        System.out.println(fib(5));
    }

    private static int fib(int n) {
        if(n<2){
            return n;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i-2] + dp[i-1]) % 1000000007;
        }
        return dp[n];
    }
}
