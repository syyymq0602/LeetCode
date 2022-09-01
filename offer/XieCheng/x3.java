package offer.XieCheng;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class x3 {
    static int n, r, g, b;
    static char[] colors;
    static List<List<Integer>> nxs = new ArrayList<>();
    static int res = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        colors = sc.nextLine().toCharArray();
        // 统计rgb的数量
        for(char c : colors) {
            if(c == 'r') r++;
            else if(c == 'g') g++;
            else b++;
        }
        // 初始化并构造无向图
        for(int i = 0; i < n; i++) nxs.add(new LinkedList<>());
        for(int i = 0; i < n - 1; i++) {
            int a = sc.nextInt() - 1;   //题目中给的下标是1开始
            int b = sc.nextInt() - 1;
            nxs.get(a).add(b);
            nxs.get(b).add(a);
        }
        // 起点随便选，-1表示不存在的节点
        dfs(1, -1);
        System.out.println(res);
    }

    static int[] dfs(int node, int pre) {
        int[] color = new int[3];
        if(colors[node] == 'r') color[0]++;
        else if(colors[node] == 'g') color[1]++;
        else color[2]++;

        //如果是叶子节点，就直接返回
        if(nxs.get(node).size() == 1 && nxs.get(node).get(0) == pre) return color;

        // 遍历相邻节点，把子树返回来的数量加到color里
        for(int nx : nxs.get(node)) {
            // nx != pre的条件是防止无向图往回走
            if(nx != pre) add(color, dfs(nx, node));
        }

        // 判断是否符合题目条件
        if(color[0] > 0 && color[1] > 0 && color[2] > 0 && r - color[0] > 0 && g - color[1] > 0 && b - color[2] > 0)  res++;
        return color;
    }

    // 数组相加
    static void add(int[] a, int[] b) {
        for(int i = 0; i < 3; i++) a[i] += b[i];
    }
}
