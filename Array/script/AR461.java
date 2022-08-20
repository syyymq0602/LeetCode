package Array.script;

/**
 * 461. 汉明距离
 *
 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 *
 * 0 <= x, y <= 2e31 - 1
 */
public class AR461 {
    public static void main(String[] args) {
        System.out.println(hammingDistance(1,4));
    }

    private static int hammingDistance(int x, int y) {
        int temp = x ^ y;
        int ret = 0;
        while (temp != 0){
            ret += temp & 1;
            temp = temp >> 1;
        }
        return ret;
    }
}
