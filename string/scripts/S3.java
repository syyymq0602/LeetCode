package string.scripts;

import java.lang.ref.WeakReference;
import java.util.HashMap;

/**
 * 3. 无重复字符的最长子串
 *
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 */
public class S3 {
    public static void main(String[] args) {
        var s = "abacvbabcaa";
        System.out.println(lengthOfLongestSubstring(s));

        WeakReference<String> str = new WeakReference<String>(new String("abc"));
        System.out.println(str.get());
        //通知JVM进行内存回收
        System.gc();
        System.out.println(str.get());
    }

    private static int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;
    }
}
