package gdyx;

/**
 * 733. 图像渲染
 *
 * 有一幅以m x n的二维整数数组表示的图画image，其中image[i][j]表示该图画的像素值大小。
 *
 * 你也被给予三个整数 sr , sc 和 newColor 。你应该从像素image[sr][sc]开始对图像进行 上色填充 。
 *
 * 为了完成 上色工作 ，从初始像素开始，记录初始坐标的 上下左右四个方向上 像素值与初始坐标相同的相连像素点，
 * 接着再记录这四个方向上符合条件的像素点与他们对应 四个方向上 像素值与初始坐标相同的相连像素点，……，重复该过程。
 * 将所有有记录的像素点的颜色值改为newColor。
 *
 * 最后返回 经过上色渲染后的图像。
 *
 * m == image.length
 * n == image[i].length
 * 1 <= m, n <= 50
 * 0 <= image[i][j], newColor < 216
 * 0 <= sr <m
 * 0 <= sc <n
 *
 */
public class G733 {
    public static void main(String[] args) {
        var images = new int[][]{
                {0,0,0},{0,2,2}
        };
        var res = floodFill(images,1,1,1);
        for (var items:res) {
            var o = "";
            for (var item:items) {
                o += item +" ";
            }
            System.out.println(o);
        }
    }

    private static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        int n = image[0].length;
        int pre = image[sr][sc];
        floodFill(image,sr,sc,newColor,pre,m,n);
        return image;
    }

    private static void floodFill(int[][] image, int sr, int sc, int newColor, int pre, int m, int n) {
        image[sr][sc] = newColor;
        if(newColor == pre){
            return;
        }
        int[][] pos = new int[][]{
                {1,0},{-1,0},{0,1},{0,-1}
        };
        for (int[] item:pos) {
            int newsr = sr + item[0];
            int newsc = sc + item[1];
            if(newsr >= 0 && newsr < m && newsc >=0 && newsc < n && image[newsr][newsc] == pre){
                image[newsr][newsc] = newColor;
                floodFill(image,newsr,newsc,newColor,pre,m,n);
            }
        }
    }
}


