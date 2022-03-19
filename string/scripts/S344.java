package string.scripts;

/**
 * 344. 反转字符串
 *
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 * 1 <= s.length <= 105
 * s[i] 都是 ASCII 码表中的可打印字符
 */
public class S344 {
    public static void main(String[] args) {
        var s = "hello";
        var sc = s.toCharArray();
        reverseString(sc);
        var out = "";
        for (var item:sc) {
            out += item + " ";
        }
        System.out.println(out);
    }

    private static void reverseString(char[] s) {
        int n = s.length;
        if (n==1){
            return;
        }
        int left = 0;
        int right = n-1;
        while (left<=right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
