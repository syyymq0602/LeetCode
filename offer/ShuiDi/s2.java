package offer.ShuiDi;

import LL.scripts.ListNode;
import LL.scripts.ListNodeUtils;

public class s2 {
    public static void main(String[] args) {
        System.out.println(sum("9999","9"));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param numA string字符串
     * @param numB string字符串
     * @return string字符串
     */
    public static String sum (String numA, String numB) {
        // write code here
        int lA = numA.length();
        int lb = numB.length();
        int count = 0;
        int minLen = Math.min(lA,lb);
        StringBuilder sbA = new StringBuilder();
        String newA = sbA.append(numA).reverse().toString();
        StringBuilder sbB = new StringBuilder();
        String newB = sbB.append(numB).reverse().toString();
        StringBuilder ansBuilder = new StringBuilder();
        for (int i = 0; i < minLen; i++) {
            int num = (newA.charAt(i) - '0') + (newB.charAt(i) - '0') + count;
            if(num / 10  > 0){
                count = num / 10;
            }else {
                count = 0;
            }
            ansBuilder.append(num % 10);
        }
        int index = minLen;
        while (index < lA){
            int num = newA.charAt(index) - '0' + count;
            if(num / 10  > 0){
                count = num / 10;
            }else {
                count = 0;
            }
            ansBuilder.append(num % 10);
            index++;
        }

        while (index < lb){
            int num = newB.charAt(index) - '0' + count;
            if(num / 10  > 0){
                count = num / 10;
            }else {
                count = 0;
            }
            ansBuilder.append(num % 10);
            index++;
        }

        if(count != 0){
            ansBuilder.append(count);
        }

        return ansBuilder.reverse().toString();
    }
}
