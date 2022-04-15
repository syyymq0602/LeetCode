package offer.special;

/**
 * 剑指 Offer II 018. 有效的回文
 *
 * 给定一个字符串 s ，验证 s 是否是 回文串 ，只考虑字母和数字字符，可以忽略字母的大小写。
 * 本题中，将空字符串定义为有效的 回文串
 *
 * 1 <= s.length <= 2 * 10e5
 * 字符串 s 由 ASCII 字符组成
 */
public class O018 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("0P"));
    }

    private static boolean isPalindrome(String s) {
        int n = s.length();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int num = c - '0';
            if((num >= 0 && num<=9) || (num>= 17 && num <= 42) || (num >= 49 && num <=74)){
                builder.append(c);
            }
        }
        int left = 0, right = builder.length()-1;
        String newstr = builder.toString();
        while (left <= right){
            if(newstr.charAt(left) == newstr.charAt(right)){
                left++;
                right--;
            }else if(newstr.charAt(left) - 'A' >= 0 && newstr.charAt(left) - 'A' <=57
                    && newstr.charAt(right) - 'A' >= 0 && newstr.charAt(right) - 'A' <=57){
                if(Math.abs(newstr.charAt(left) - newstr.charAt(right)) == 32){
                    left++;
                    right--;
                }else {
                    return false;
                }
            }else {
                return false;
            }
        }
        return true;
    }
}
