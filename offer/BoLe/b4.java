package offer.BoLe;

import java.util.HashMap;
import java.util.Map;

public class b4 {
    public static void main(String[] args) {
        System.out.println(cross_river(new int[]{0,1,2,3,4,8,9,11}));
    }

    static boolean flag;
    static int[] dir = new int[]{-1,0,1};

    private static boolean cross_river(int[] stones) {
        // write code here
        if (stones[1] != 1) {
            return false;
        }
        int len = stones.length;
        int target = stones[len - 1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(stones[i],i);
        }
        flag = false;
        dfs(stones,1,target,map,1);
        return flag;
    }

    private static void dfs(int[] stones, int k, int target, Map<Integer, Integer> map,int index) {
        if(index >= stones.length){
            return;
        }
        if(index == stones.length -1){
            flag = true;
            return;
        }
        for (int d : dir) {
            int newItem = stones[index] + k + d;
            if(newItem <= stones[index] || !map.containsKey(newItem)){
                continue;
            }
            int newIndex = map.get(newItem);
            int newK = stones[newIndex] - stones[index];
            dfs(stones,newK,target,map,newIndex);
        }
    }
}
