package offer.scripts;

/**
 * 剑指 Offer 12. 矩阵中的路径
 *
 * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用
 *
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * board 和 word 仅由大小写英文字母组成
 */
public class o12 {
    public static void main(String[] args) {
        var board = new char[][]{
                {'A','B','C','E'},
                {'S','F','E','S'},
                {'A','D','E','E'}
        };
        System.out.println(exist(board,"ABCESEEEFS"));
    }

    private static boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j] == word.charAt(0)){
                    boolean[][] check = new boolean[n][m];
                    if(exist(board,word,0,check,i,j)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean exist(char[][] board, String word, int index, boolean[][] check,int row,int col) {
        if(board[row][col] != word.charAt(index)){
            return false;
        }
        if(index == word.length()-1){
            return true;
        }
        check[row][col] = true;
        boolean res = false;
        int[][] pos = new int[][]{
                {1,0},{-1,0},{0,1},{0,-1}
        };
        for (int[] item:pos) {
            int newi = row + item[0];
            int newj = col + item[1];
            if(newi >=0 && newi < board.length && newj >= 0 && newj < board[0].length){
                if(!check[newi][newj]){
                    if(exist(board,word,index+1,check,newi,newj)){
                        res = true;
                        break;
                    }
                }
            }
        }
        // 回溯一下 防止错误设置真值
        check[row][col] = false;
        return res;
    }
}
