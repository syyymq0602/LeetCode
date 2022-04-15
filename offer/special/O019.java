package offer.special;

/**
 * 剑指 Offer II 019. 最多删除一个字符得到回文
 *
 * 给定一个非空字符串 s，请判断如果 最多 从字符串中删除一个字符能否得到一个回文字符串
 *
 * 1 <= s.length <= 10e5
 * s 由小写英文字母组成
 */
public class O019 {
    public static void main(String[] args) {
        System.out.println(validPalindrome("avvvba"));
    }

    private static boolean validPalindrome(String s) {
        int n = s.length();
        int left = 0, right = n-1;
        while (left < right){
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }else {
                return validPalindrome(s,left,right-1) || validPalindrome(s,left+1,right);
            }
        }
        return true;
    }

    private static boolean validPalindrome(String s, int low, int high) {
        for (int i = low, j = high; i < j; ++i, --j) {
            char c1 = s.charAt(i), c2 = s.charAt(j);
            if (c1 != c2) {
                return false;
            }
        }
        return true;
    }
}
