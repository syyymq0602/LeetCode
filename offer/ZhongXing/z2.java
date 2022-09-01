package offer.ZhongXing;

import java.util.*;

public class z2 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextLine()) {
            String timeStr = cin.nextLine();
            timeStr = timeStr.replace("[", "").replace("]", "");
            String[] timesStr = timeStr.split(",");
            int row = timesStr.length / 3;
            int[][] times = new int[row][3];
            for (int i = 0; i < timesStr.length; i++) {
                times[i / 3][i % 3] = Integer.parseInt(timesStr[i]);
            }
            // [[2,1,1],[2,3,1],[3,4,1]]
            int N = Integer.parseInt(cin.nextLine());
            int K = Integer.parseInt(cin.nextLine());
            int[] islands = new int[N + 1];
            Arrays.fill(islands, -1);
            islands[0] = 0;
            islands[K] = 0;
            for (int i = 0; i < times.length; i++) {
                if (islands[times[i][1]] == -1) {
                    islands[times[i][1]] = 1;
                } else {
                    islands[times[i][1]]++;
                }
            }
            // 岛屿不可达
            if (!check(islands, false)) {
                System.out.println(-1);
                continue;
            }
            // 初始化集合，存储二维数组下标
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < times.length; i++) {
                if (!map.containsKey(times[i][0])) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(times[i][0], list);
                } else {
                    List<Integer> l = map.get(times[i][0]);
                    l.add(i);
                    map.put(times[i][0], l);
                }
            }
            // 标记是否走过,防止两个岛屿来回走
            boolean[] mark = new boolean[N+1];
            int ans = dfs(map,mark,times,K);
            System.out.println(ans);
        }
    }

    private static int dfs(Map<Integer, List<Integer>> map, boolean[] mark, int[][] times, int k) {
        if(!map.containsKey(k)){
            return 0;
        }

        List<Integer> list = map.get(k);
        mark[k] = true;
        int min = 0;
        for (int i = 0; i < list.size(); i++) {
            int index = list.get(i);
            int nextNum = times[index][1];
            int interval = times[index][2];
            if(!mark[nextNum]){
                mark[nextNum] = true;
                int time = dfs(map,mark,times,nextNum);
                time += interval;
                min = Math.max(min, time);
                mark[nextNum] = false;
            }
        }
        return min;
    }

    private static boolean check(int[] islands, boolean cond) {
        for (int i = 1; i < islands.length; i++) {
            if (islands[i] == -1) {
                return false;
            }
        }
        return true;
    }
}


