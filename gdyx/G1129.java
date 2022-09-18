package gdyx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1129. 颜色交替的最短路径
 *
 * 在一个有向图中，节点分别标记为0, 1, ..., n-1。图中每条边为红色或者蓝色，且存在自环或平行边。
 * red_edges中的每一个[i, j]对表示从节点 i 到节点 j 的红色有向边。
 * 类似地，blue_edges中的每一个[i, j]对表示从节点 i 到节点 j 的蓝色有向边。
 * 返回长度为 n 的数组answer，其中answer[X]是从节点0到节点X的红色边和蓝色边交替出现的最短路径的长度。
 * 如果不存在这样的路径，那么 answer[x] = -1。
 *
 * 1 <= n <= 100
 * red_edges.length <= 400
 * blue_edges.length <= 400
 * red_edges[i].length == blue_edges[i].length == 2
 * 0 <= red_edges[i][j], blue_edges[i][j] < n
 */
public class G1129 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(shortestAlternatingPaths(3,new int[][]{{0,1}},new int[][]{{1,2}})));
    }

    private static int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        //2 <= n <= 1000
        //边的集合转换为邻接表
        ArrayList<Integer>[] redList =new ArrayList[n];
        ArrayList<Integer>[] blueList =new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            redList[i] = new ArrayList<>();
            blueList[i] = new ArrayList<>();
        }
        for (int[] edge : redEdges){
            redList[edge[0]].add(edge[1]);
        }
        for (int[] edge : blueEdges){
            blueList[edge[0]].add(edge[1]);
        }

        boolean[] redVisited = new boolean[n];
        boolean[] blueVisited = new boolean[n];
        //BFS,<v,color,len>
        Queue<int[]> queue = new LinkedList<>();
        //0-red,1-blue
        //初始0可以走红色和蓝色两条路
        queue.add(new int[]{0, 0, 0});
        queue.add(new int[]{0, 1, 0});
        //注意，因为有红蓝两种选择，则应该有两种标记
        redVisited[0] = true; //标记访问
        blueVisited[0] = true; //标记访问
        int[] res = new int[n];
        Arrays.fill(res, -1);
        while (!queue.isEmpty()) {
            int[] x = queue.poll();
            int v = x[0], color = x[1], len = x[2];
            if (res[v] == -1){ //第一次访问为最小距离
                res[v] = len;
            }
            if (color == 0) { //red
                for (int w : blueList[v]) {
                    if ( !blueVisited[w]) {
                        blueVisited[w] = true; //标记访问
                        queue.add(new int[]{w, 1, len + 1});
                    }
                }
            } else {
                for (int w : redList[v]) {
                    if ( !redVisited[w]) {
                        redVisited[w] = true; //标记访问
                        queue.add(new int[]{w, 0, len + 1});
                    }
                }
            }
        }
        return res;
    }
}
