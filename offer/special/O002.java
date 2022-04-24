package offer.special;

/**
 * 剑指 Offer II 002. 二进制加法
 *
 * 给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。
 * 输入为 非空 字符串且只包含数字 1 和 0
 *
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零
 */
public class O002 {
    public static void main(String[] args) {
        System.out.println(addBinary("1111111","10"));
    }

    private static String addBinary(String a, String b) {
        char[] chars1 = a.toCharArray();
        char[] chars2 = b.toCharArray();
        int maxSize = Math.max(chars1.length, chars2.length);
        StringBuilder builder = new StringBuilder();
        int index = 0;
        for (int i = 0; i < maxSize; ++i) {
            index += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            index += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            builder.append((char) (index % 2 + '0'));
            index /= 2;
        }
        while (index != 0){
            builder.append('1');
            index /= 2;
        }
        return builder.reverse().toString();
    }
}
