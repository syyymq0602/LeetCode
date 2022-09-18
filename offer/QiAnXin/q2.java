package offer.QiAnXin;

public class q2 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 得到最短路径长度
     * @param points int整型二维数组 食物位置
     * @return int整型
     */
    private static int ans;
    public static int getMinLen (int[][] points) {
        // write code here
        ans = 0;
        int total = points.length;
        boolean[] visited = new boolean[total];
        int step = 0;
        dfs(points,step,visited,total,0,0);
        return ans;
    }

    private static void dfs(int[][] points, int step, boolean[] visited, int total,int x,int y) {
        if(step == total){
            return;
        }
        int minPath = Integer.MAX_VALUE;
        int index = -1;
        int newX = x,newY = y;
        for (int i = 0; i < points.length; i++) {
            if(visited[i]){
                continue;
            }
            int dis = Math.abs(x-points[i][0]) + Math.abs(y-points[i][1]);
            if(dis < minPath){
                newX = points[i][0];
                newY = points[i][1];
                minPath = dis;
                index = i;
            }
        }
        ans += minPath;
        visited[index] = true;
        step++;
        dfs(points,step,visited,total,newX,newY);
    }


    public static void main(String[] args) {
        System.out.println(getMinLen(new int[][]{
                {0,5},{1,1}
        }));
    }
}
