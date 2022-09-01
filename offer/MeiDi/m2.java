package offer.MeiDi;

import java.util.ArrayList;

public class m2 {
    public static void main(String[] args) {
        System.out.println(findPrimeNumber(1,10).toString());
    }

    public static ArrayList<Integer> findPrimeNumber (int m, int n) {
        // write code here
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = m; i <= n; i++) {
            if(i == 1 || i == 2){
                ans.add(i);
                continue;
            }
            if(i % 2 == 0){
                continue;
            }
            boolean flag = true;
            int maxJudge = (int) Math.sqrt(i);
            for (int j = 2; j <= maxJudge; j++) {
                if(i % j == 0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                ans.add(i);
            }
        }
        return ans;
    }
}
