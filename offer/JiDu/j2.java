package offer.JiDu;

import java.util.Arrays;
import java.util.Scanner;

public class j2 {
    public static void main(String[] args) {
        System.out.println(isEquals("aba","aab"));
    }

    public static boolean isEquals (String str1, String str2) {
        // write code here
        int[] nums1 = new int[26];
        int[] nums2 = new int[26];
        int len1 = str1.length();
        int len2 = str2.length();
        if(len1 != len2){
            return false;
        }
        for (int i = 0; i < len1; i++) {
            nums1[str1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < len2; i++) {
            nums2[str2.charAt(i) - 'a']++;
        }
        return Arrays.equals(nums1,nums2);
    }
}
