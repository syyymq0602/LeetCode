package NK;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 小团是某综艺节目的策划，他为某个游戏环节设计了一种晋级规则，已知在这个游戏环节中每个人最后都会得到一个分数score_i，
 * 显而易见的是，游戏很有可能出现同分的情况，小团计划该环节晋级人数为x人，则将所有人的分数从高到低排序，
 * 所有分数大于等于第x个人的分数且得分不为0的人都可以晋级。
 *
 * 请你求出本环节的实际晋级人数。显然这个数字可能是0，如果所有人的得分都是0，则没有人满足晋级条件。
 *
 * 输入第一行包含两个正整数n和x，分别表示参加本环节的人数，和小团指定的x。
 * 输入第二行包含n个整数，每个整数表示一位选手的得分。
 *
 * 输出仅包含一个整数，表示实际晋级人数。
 */
public class NK3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] r1 = new int[2];
        while (scanner.hasNext()){
            for (int i = 0; i < r1.length; i++) {
                r1[i] = scanner.nextInt();
            }
            int[] r2 = new int[r1[0]];
            for (int i = 0; i < r2.length; i++) {
                r2[i] = scanner.nextInt();
            }
            Arrays.sort(r2);
            if(r1[1] == 0){
                System.out.println(0);
                break;
            }
            int index = r2.length - r1[1];
            int num = 0;
            int target = r2[index];
            if(target == 0){
                for (int i = index; i < r2.length; i++) {
                    if(r2[i] > 0 ){
                        num++;
                    }
                }
                System.out.println(num);
            }else {
                for (int i = 0; i < index; i++) {
                    if(r2[i] == target){
                        num++;
                    }
                }
                System.out.println(num+r1[1]);
            }

        }
    }
}
