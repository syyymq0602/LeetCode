
import java.util.Scanner;

public class templateInput1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String s = scanner.nextLine();
            int n = s.length();
            if(n == 1){
                System.out.println(0);
                continue;
            }
            boolean[] p = new boolean[n];
            int[] dp = new int[n];
            dp[0] = 0;
            for (int i = 1; i < n; i++) {
                if(p[i-1]){
                    dp[i] = dp[i-1];
                }else {
                    int diff = Math.abs(s.charAt(i-1) - s.charAt(i));
                    if(diff == 0 || diff == 1){
                        dp[i] = dp[i-1] + (s.charAt(i-1) - 'a' + 1) + (s.charAt(i) - 'a' + 1);
                        p[i-1] = p[i] = true;
                    }else {
                        dp[i] = dp[i-1];
                    }
                }
            }
            System.out.println(dp[n-1]);
        }
    }
}
