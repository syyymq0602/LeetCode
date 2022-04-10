package offer.scripts;

/**
 * 剑指 Offer 13. 机器人的运动范围
 *
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
 * 请问该机器人能够到达多少个格子？
 *
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 */
public class o13 {
    private static int res = 0;
    public static void main(String[] args) {
        System.out.println(movingCount(3,2,17));
    }

    private static int movingCount(int m, int n, int k) {
        res = 0;
        boolean[][] mark = new boolean[m][n];
        movingCount(m,n,k,0,0,mark);
        return res;
    }

    private static void movingCount(int m, int n, int k, int row, int col,boolean[][] mark) {
        if(check(row,col)>k){
            return;
        }
        res++;
        mark[row][col] = true;
        int[][] dir = new int[][]{
                {1,0},{-1,0},{0,1},{0,-1}
        };
        for (int[] item:dir) {
            int newi = row + item[0];
            int newj = col + item[1];
            if(newi >= 0 && newi<m && newj>=0 && newj<n){
                if(!mark[newi][newj]){
                    movingCount(m,n,k,newi,newj,mark);
                }
            }
        }
    }


    private static int check(int i,int j){
        return check(i) + check(j);
    }

    private static int check(int num){
        int sum = 0;
        if(num >= 100){
            sum = 1;
        }else if(num < 10){
            sum = num;
        }else {
            sum += num %10;
            sum += num/10;
        }
        return sum;
    }
}
