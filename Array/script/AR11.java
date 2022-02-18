package Array.script;

/**
 * 11. 盛最多水的容器
 *
 * 给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是(i, 0)和(i, height[i])。
 *
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器。
 *
 * n == height.length
 * 2 <= n <= 105
 * 0 <= height[i] <= 104
 */
public class AR11 {
    public static void main(String[] args) {
        var height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    private static int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n-1;
        int res = 0;
        while (left<right){
            res = Math.max(res,Math.min(height[left],height[right])*(right-left));
            if(height[left] < height[right]){
                left++;
            }else {
                right--;
            }
        }
        return res;
    }
}
