package offer.scripts;

/**
 * 剑指 Offer 46. 把数字翻译成字符串
 *
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法
 *
 * 0 <= num < 2e31
 */
public class o46 {
    public static void main(String[] args) {
        System.out.println(translateNum(506));
    }

    private static int translateNum(int num) {
        String s = Integer.toString(num);
        int len = s.length();
        if(len == 1) return 1;
        if(len == 2) return check(s.substring(0,2))?2:1;
        int[] dp = new int[len];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < len; i++) {
            if(check(s.substring(i-2,i))){
                dp[i] = dp[i-1] + dp[i-2];
            }else {
                dp[i] = dp[i-1];
            }
        }
        return dp[len-1];
    }

    private static boolean check(String substring) {
        int num = Integer.parseInt(substring);
        return num >= 10 && num <= 25;
    }
}
