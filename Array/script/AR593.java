package Array.script;

/**
 * 593. 有效的正方形
 *
 * 给定2D空间中四个点的坐标 p1, p2, p3和 p4，如果这四个点构成一个正方形，则返回 true 。
 * 点的坐标pi 表示为 [xi, yi] 。输入 不是 按任何顺序给出的。
 * 一个 有效的正方形 有四条等边和四个等角(90度角)。
 *
 * p1.length == p2.length == p3.length == p4.length == 2
 * -10e4 <= xi, yi <= 10e4
 */
public class AR593 {
    public static void main(String[] args) {
        System.out.println(validSquare(new int[]{0,0},new int[]{1,1},new int[]{1,0},new int[]{0,1}));
    }

    private static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] pos = new int[][]{
          p1,p2,p3,p4
        };
        for (int i = 0; i < pos.length; i++) {
            for (int j = i+1; j < pos.length; j++) {
                if(pos[i][0] == pos[j][0] && pos[i][1] == pos[j][1]){
                    return false;
                }
            }
        }
        long minLen = Integer.MAX_VALUE;
        long maxLen = -1;
        int[] maxPoint = new int[2];
        int index = 0;
        for (int i = 1; i < pos.length; i++) {
            long len = (long) (pos[i][0] - p1[0]) * (pos[i][0] - p1[0])
                    + (long) (pos[i][1] - p1[1]) * (pos[i][1] - p1[1]);
            if(len > maxLen){
                maxLen = len;
                maxPoint = pos[i];
                index = i;
            }else {
                minLen = len;
            }
        }
        if(maxLen != 2 * minLen){
            return false;
        }
        for (int i = 0; i < pos.length; i++) {
            if(i == index){
                continue;
            }
            long len = (long) (pos[i][0] - maxPoint[0]) * (pos[i][0] - maxPoint[0])
                    + (long) (pos[i][1] - maxPoint[1]) * (pos[i][1] - maxPoint[1]);
            if(len != maxLen && len != minLen){
                return false;
            }
        }
        return true;
    }
}
