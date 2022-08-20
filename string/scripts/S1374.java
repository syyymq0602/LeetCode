package string.scripts;

/**
 * 1374. 生成每种字符都是奇数个的字符串
 *
 * 给你一个整数 n，请你返回一个含 n 个字符的字符串，其中每种字符在该字符串中都恰好出现 奇数次 。
 * 返回的字符串必须只含小写英文字母。如果存在多个满足题目要求的字符串，则返回其中任意一个即可
 *
 * 1 <= n <= 500
 */
public class S1374 {
    public static void main(String[] args) {
        System.out.println(generateTheString(3));
    }

    private static String generateTheString(int n) {
        if(n ==1){
            return "a";
        }
        int[] ans;
        if(n % 2 == 0){
            ans = new int[]{1,n-1,0};
        }else {
            ans = new int[]{1,1,n-2};
        }
        char[] chars = new char[]{'a','b','c'};
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < ans.length; i++) {
            if(ans[i] == 0){
                continue;
            }
            for (int j = 0; j < ans[i]; j++) {
                builder.append(chars[i]);
            }
        }
        return builder.toString();
    }
}
