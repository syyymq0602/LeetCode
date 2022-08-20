package string.scripts;

import java.util.HashMap;
import java.util.Map;

/**
 * 2283. 判断一个数的数字计数是否等于数位的值
 *
 * 给你一个下标从 0开始长度为 n的字符串num，它只包含数字。
 * 如果对于 每个0 <= i < n的下标i，都满足数位i在 num中出现了num[i]次，那么请你返回true，否则返回false
 *
 * n == num.length
 * 1 <= n <= 10
 * num 只包含数字
 */
public class S2283 {
    public static void main(String[] args) {
        System.out.println(digitCount("030"));
    }

    private static boolean digitCount(String num) {
        int n = num.length();
        Map<Integer,Integer> map = new HashMap<>();
        boolean ans = true;
        for (int i = 0; i < n; i++) {
            int key = num.charAt(i) - '0';
            map.put(key, map.getOrDefault(key,0)+1);
        }
        for (int i = 0; i < n; i++) {
            int dig = num.charAt(i) - '0';
            int count = map.getOrDefault(i,0);
            if(dig != count){
                ans = false;
                break;
            }
        }
        return ans;
    }
}
