package offer.BoLe;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class b2 {
    public static void main(String[] args) {
        System.out.println(maxProfitAssignment(new int[]{2,4,6,8,10},new int[]{10,20,30,40,50},new int[]{4,5,6,7}));
    }

    private static int maxProfitAssignment (int[] difficulty, int[] profit, int[] worker) {
        // write code here
        int n = difficulty.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<n;i++){
            if(!map.containsKey(difficulty[i])){
                map.put(difficulty[i],profit[i]);
            }else{
                int max = Math.max(map.get(difficulty[i]),profit[i]);
                map.put(difficulty[i],max);
            }
        }
        Arrays.sort(difficulty);
        int minDiff = difficulty[0];
        int sum = 0;
        for(int i = 0;i<worker.length;i++){
            if(worker[i] < minDiff){
                continue;
            }
            int index = 0;
            int temp = 0;
            while(index < n){
                if(difficulty[index] > worker[i]){
                    break;
                }
                temp = Math.max(temp,map.get(difficulty[index]));
                index++;
            }
            sum += temp;
        }
        return sum;
    }
}
