package string.scripts;

/**
 * 828. 统计子串中的唯一字符
 *
 * 我们定义了一个函数 countUniqueChars(s) 来统计字符串 s 中的唯一字符，并返回唯一字符的个数。
 * 例如：s = "LEETCODE" ，则其中 "L", "T","C","O","D" 都是唯一字符，因为它们只出现一次，所以 countUniqueChars(s) = 5 。
 * 本题将会给你一个字符串 s ，我们需要返回 countUniqueChars(t) 的总和，其中 t 是 s 的子字符串。输入用例保证返回值为 32 位整数。
 * 注意，某些子字符串可能是重复的，但你统计时也必须算上这些重复的子字符串（也就是说，你必须统计 s 的所有子字符串中的唯一字符）
 *
 * 1 <= s.length <= 10^5
 * s 只包含大写英文字符
 */
public class S828 {
    public static void main(String[] args) {
        System.out.println(uniqueLetterString("ABC"));
    }

    private static int uniqueLetterString(String s) {
        int n = s.length();
        if (n == 1) {
            return 1;
        }
        char[] ch = s.toCharArray();
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            left[i] = -1;
            right[i] = n;
        }

        int[] prev = new int[26];
        int[] next = new int[26];
        for (int i = 0; i < 26; i++) {
            prev[i] = -1;
            next[i] = n;
        }

        for (int i = 0; i < n; i++) {
            int idx = ch[i] - 'A';
            left[i] = prev[idx];
            prev[idx] = i;
        }

        for (int i = n - 1; i >= 0; i--) {
            int idx = ch[i] - 'A';
            right[i] = next[idx];
            next[idx] = i;
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res += (i - left[i]) * (right[i] - i);
        }

        return res;
    }
}
