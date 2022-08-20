package offer.ShenCe;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class s2 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while(cin.hasNextLine()) {
            int n = Integer.parseInt(cin.nextLine());
            String time = cin.nextLine();
            String[] times = time.split(" ");
            Arrays.sort(times);
            // 当前时间与下个时间的时间差，以秒为计算
            HashMap<Integer,String> map = new HashMap<>();
            for (int i = 0; i < n-1; i++) {
                int interval = getTime(times[i],times[i+1],false);
                if(!map.containsKey(interval)){
                    map.put(interval,times[i]);
                }
            }
            int gt = getTime(times[n-1],times[0],true);
            if(!map.containsKey(gt)){
                map.put(gt,times[n-1]);
            }
            int maxInterval = 0;
            String startTime = "";
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                if(maxInterval < entry.getKey()){
                    maxInterval = entry.getKey();
                    startTime = entry.getValue();
                }
            }
            System.out.println(startTime);
        }
    }

    private static int getTime(String t1, String t2,boolean gt) {
        String[] t1s = t1.split(":");
        String[] t2s = t2.split(":");
        int hour = Integer.parseInt(t2s[0]) - Integer.parseInt(t1s[0]);
        if(gt){
            hour = 24 + hour;
        }
        int min = Integer.parseInt(t2s[1]) - Integer.parseInt(t1s[1]);
        int sec = Integer.parseInt(t2s[2]) - Integer.parseInt(t1s[2]);
        return hour * 3600 + min * 60 + sec;
    }
}
