package BT.scripts;

import java.util.*;

/**
 * 655. 输出二叉树
 *
 * 给你一棵二叉树的根节点 root ，请你构造一个下标从 0 开始、大小为 m x n 的字符串矩阵 res ，
 * 用以表示树的 格式化布局 。构造此格式化布局矩阵需要遵循以下规则：
 *
 * 树的 高度 为 height ，矩阵的行数 m 应该等于 height + 1 。
 * 矩阵的列数 n 应该等于 2height+1 - 1 。
 * 根节点 需要放置在 顶行 的 正中间 ，对应位置为 res[0][(n-1)/2] 。
 * 对于放置在矩阵中的每个节点，设对应位置为 res[r][c] ，将其左子节点放置在 res[r+1][c-2^(height-r-1)] ，右子节点放置在 res[r+1][c+2^(height-r-1)] 。
 * 继续这一过程，直到树中的所有节点都妥善放置。
 * 任意空单元格都应该包含空字符串 "" 。
 * 返回构造得到的矩阵 res 。
 *
 * 树中节点数在范围 [1, 2e10] 内
 * -99 <= Node.val <= 99
 * 树的深度在范围 [1, 10] 内
 */
public class BT655 {
    public static void main(String[] args) {
        var root = TreeNodeUtils.generateByList(Arrays.asList(1,2,3,null,4));
        var res = printTree(root);
        for (var item : res){
            System.out.println(item.toString());
        }
    }

    private static List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        int line = (int)Math.pow(2,height)-1;
        String[][] strings = new String[height][line];
        dfs(strings,height,line,0,(line - 1) / 2,root);
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            List<String> t = new ArrayList<>();
            for (int j = 0; j < strings[i].length; j++) {
                if(strings[i][j] == null){
                    t.add("");
                }else {
                    t.add(strings[i][j]);
                }
            }
            ans.add(t);
        }
        return ans;
    }

    private static void dfs(String[][] strings, int m, int n, int x, int y,TreeNode node) {
        if(node == null){
            return;
        }
        if(x >= m || y >= n){
            return;
        }
        strings[x][y] = node.val + "";
        int newX = x + 1;
        int newY_left = y - (int)Math.pow(2,m - 1 - newX);
        int newY_right = y + (int)Math.pow(2,m - 1 - newX);
        dfs(strings,m,n,newX,newY_left,node.left);
        dfs(strings,m,n,newX,newY_right,node.right);
    }

    private static int getHeight(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        while (!queue.isEmpty()){
            count++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if(temp.left!=null){
                    queue.offer(temp.left);
                }
                if(temp.right!=null){
                    queue.offer(temp.right);
                }
            }
        }
        return count;
    }
}
