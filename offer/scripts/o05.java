package offer.scripts;

/**
 * 剑指 Offer 05. 替换空格
 *
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"
 *
 * 0 <= s 的长度 <= 1000
 */
public class o05 {
    public static void main(String[] args) {
        var s = "We are happy.";
        System.out.println(replaceSpace(s));
    }

    private static String replaceSpace(String s) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' '){
                buffer.append("%20");
            }else {
                buffer.append(s.charAt(i));
            }
        }
        return buffer.toString();
    }
}
