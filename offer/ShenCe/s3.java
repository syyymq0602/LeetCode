package offer.ShenCe;

import java.util.Scanner;

public class s3 {
    private static int ans;
    public static void main (String[] args) {
        Scanner cin = new Scanner(System.in);
        int M, N;
//        while(cin.hasNextInt())
//        {
//            // 逐行读取输入
//            M = cin.nextInt();
//            N = cin.nextInt();
//            ans = 0;
//            dfs(3,M,N,new StringBuilder());
//            System.out.println(ans);
//        }
        String b = String.valueOf("4399");
        String a = "4399";
        System.out.println(a == b);
        System.out.println(a.equals(b));
        Integer c = 2;
        Integer d = Integer.valueOf(2);
        System.out.println(c == d);
        System.out.println(c.equals(d));
        Integer e = 129;
        Integer f = Integer.valueOf(129);
        System.out.println(e == f);
        System.out.println(e.equals(f));
    }

    private static void dfs(int power,int m,int n,StringBuilder b){
        if(power < 0 || m < 0 || n<0){
            return;
        }
        if(power == 0 && m == 0 && n == 0){
            ++ans;
            System.out.println(b.toString());
            return;
        }
        power = power * 2;
        b.append("m");
        dfs(power,m-1,n,b);
        b.deleteCharAt(b.length()-1);
        power = power / 2 - 1;
        b.append("n");
        dfs(power,m,n-1,b);
        b.deleteCharAt(b.length()-1);
    }

    private static boolean isNotFailed(char ch) {
        switch (ch){
            case 'f':;
            case 'a':;
            case 'i':;
            case 'l':;
            case 'e':;
            case 'd':
                return false;
            default:
                return true;
        }
    }
}
