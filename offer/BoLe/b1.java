package offer.BoLe;

import java.util.ArrayList;

public class b1 {
    public static void main(String[] args) {
        System.out.println(compose(new String[]{
                "Data","from","Qunar","showed","longhaul","trips","faced","some","challenges","in","early","August"
        },20).toString());
    }

    private static ArrayList<String> compose (String[] words, int maxWidth) {
        // write code here
        ArrayList<String> list = new ArrayList<>();
        int right = 0,n = words.length;
        while (true){
            int left = right;
            int totalLen = 0;
            while (right < n && totalLen + words[right].length() + right - left <= maxWidth){
                totalLen += words[right].length();
                right++;
            }
            if(right == n){
                StringBuilder sb = getSB(words,left,n," ");
                sb.append(getBlank(maxWidth - sb.length()));
                list.add(sb.toString());
                return list;
            }

            int numW = right - left;
            int numS = maxWidth - totalLen;

            if(numW == 1){
                StringBuilder sb = new StringBuilder(words[left]);
                sb.append(getBlank(numS));
                list.add(sb.toString());
                continue;
            }

            int aveNum = numS / (numW - 1);
            int es = numS % (numW - 1);
            StringBuilder sb = new StringBuilder();
            sb.append(getSB(words,left,left + es + 1,getBlank(aveNum + 1)));
            sb.append(getBlank(aveNum));
            sb.append(getSB(words,left + es + 1,right,getBlank(aveNum)));
            list.add(sb.toString());
        }
    }

    private static String getBlank(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    private static StringBuilder getSB(String[] words, int left, int right, String s) {
        StringBuilder sb = new StringBuilder(words[left]);
        for (int i = left + 1; i <  right; i++) {
            sb.append(s);
            sb.append(words[i]);
        }
        return sb;
    }
}
