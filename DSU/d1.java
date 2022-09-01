package DSU;

import java.util.Arrays;

/**
 * 684. 冗余连接
 *
 * 树可以看成是一个连通且 无环的无向图。
 * 给定往一棵n 个节点 (节点值1～n) 的树中添加一条边后的图。添加的边的两个顶点包含在 1 到 n中间，
 * 且这条附加的边不属于树中已存在的边。图的信息记录于长度为 n 的二维数组 edges，edges[i] = [ai, bi]表示图中在 ai 和 bi 之间存在一条边。
 * 请找出一条可以删去的边，删除后可使得剩余部分是一个有着 n 个节点的树。如果有多个答案，则返回数组edges中最后出现的边。
 *
 * n == edges.length
 * 3 <= n <= 1000
 * edges[i].length == 2
 * 1 <= ai< bi<= edges.length
 * ai != bi
 * edges 中无重复元素
 * 给定的图是连通的
 */
public class d1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findRedundantConnection(new int[][]{
                {1,2},{2,3},{3,4},{1,4},{1,5}
        })));
    }

    private static int[] findRedundantConnection(int[][] edges) {
        dsu d = new dsu();
        for (int i = 0; i < edges.length; i++) {
            if (d.same(edges[i][0], edges[i][1])) {
                return edges[i];
            } else  {
                d.join(edges[i][0], edges[i][1]);
            }
        }
        return null;
    }

    static class dsu{
        private int n;  // 节点数量3 到 1000
        private int[] father;
        public dsu() {
            n = 1005;
            father = new int[n];

            // 并查集初始化
            for (int i = 0; i < n; ++i) {
                father[i] = i;
            }
        }

        // 并查集里寻根的过程
        public int find(int u) {
            if(u == father[u]) {
                return u;
            }
            father[u] = find(father[u]);
            return father[u];
        }

        // 将v->u 这条边加入并查集
        public void join(int u, int v) {
            u = find(u);
            v = find(v);
            if (u == v) return ;
            father[v] = u;
        }

        // 判断 u 和 v是否找到同一个根，本题用不上
        public Boolean same(int u, int v) {
            u = find(u);
            v = find(v);
            return u == v;
        }
    }
}
