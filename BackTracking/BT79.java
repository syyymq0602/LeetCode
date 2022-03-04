package BackTracking;

/**
 * 79. 单词搜索
 * <p>
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board 和 word 仅由大小写英文字母组成
 */
public class BT79 {
    public static void main(String[] args) {
        var board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        var word = "SEE";
        System.out.println(exist(board, word));
    }

    private static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] state = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (judge(i, j, board, word, state, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean judge(int i, int j, char[][] board, String word, boolean[][] visited, int index) {
        if (board[i][j] != word.charAt(index)) {
            return false;
        } else if (index == word.length() - 1) {
            return true;
        }
        int[][] dir = new int[][]{
                {0, 1}, {0, -1}, {1, 0}, {-1, 0}
        };
        visited[i][j] = true;
        boolean res = false;
        for (int[] d : dir) {
            int newi = i + d[0];
            int newj = j + d[1];
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[i].length) {
                if (!visited[newi][newj]) {
                    if (judge(newi, newj, board, word, visited, index + 1)) {
                        res = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return res;
    }
}
