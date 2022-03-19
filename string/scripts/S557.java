package string.scripts;

/**
 * 557. 反转字符串中的单词 III
 *
 * 给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序
 *
 * 1 <= s.length <= 5 * 104
 * s包含可打印的 ASCII 字符。
 * s不包含任何开头或结尾空格。
 * s里 至少 有一个词。
 * s中的所有单词都用一个空格隔开
 *
 */
public class S557 {
    public static void main(String[] args) {
        var s = "Let's take LeetCode contest";
        String reverseWords = reverseWords(s);
        System.out.println(reverseWords);
    }

    private static String reverseWords(String s) {
        String[] s1 = s.split(" ");
        for (int i = 0; i < s1.length; i++) {
            s1[i] = reverseString(s1[i]);
        }

        return String.join(" ",s1);
    }

    private static String reverseString(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int left = 0;
        int right = n-1;
        while (left<=right){
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return String.valueOf(arr);
    }
}
