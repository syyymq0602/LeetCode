package DP.scripts;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. 杨辉三角 II
 *
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 * 0 <= rowIndex <= 33
 */
public class DP119 {
    public static void main(String[] args) {
        var rowIndex = 12;
        for(var item : getRow(rowIndex)){
            System.out.print(item + " ");
        }
    }

    private static List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            res.add(0);
            for (int j = i; j > 0; j--) {
                res.set(j,res.get(j)+res.get(j-1));
            }
        }
        return res;
    }
}
