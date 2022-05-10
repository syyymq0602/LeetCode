package offer.special;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剑指 Offer II 100. 三角形中最小路径之和
 *
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1
 *
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -10e4 <= triangle[i][j] <= 10e4
 */
public class O100 {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3,4));
        triangle.add(Arrays.asList(6,5,7));
        triangle.add(Arrays.asList(4,1,8,3));
        System.out.println(minimumTotal(triangle));
    }

    private static int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        if(len == 1){
            return triangle.get(0).get(0);
        }
        for (int i = 1; i < len; i++) {
            triangle.get(i).set(0,triangle.get(i-1).get(0) + triangle.get(i).get(0));
            int lastIndex = triangle.get(i).size()-1;
            triangle.get(i).set(lastIndex,triangle.get(i-1).get(triangle.get(i-1).size()-1) + triangle.get(i).get(lastIndex));
        }

        for (int i = 1; i < len; i++) {
            int n = triangle.get(i).size();
            for (int j = 1; j < n-1; j++) {
                int min = Math.min(triangle.get(i-1).get(j-1),triangle.get(i-1).get(j)) + triangle.get(i).get(j);
                triangle.get(i).set(j,min);
            }
        }
        List<Integer> last = triangle.get(len-1);
        int ans = last.get(0);
        for (int i = 1; i < last.size(); i++) {
            if(ans > last.get(i)){
                ans = last.get(i);
            }
        }
        return ans;
    }
}
