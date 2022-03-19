import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class q2 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while(cin.hasNextLine()) {
            String n1 = cin.nextLine();
            String in="";
            int index = 0;
            while (index < 1) {
                in = cin.nextLine();
                index++;
            }
            int n = Integer.parseInt(n1);
            String[] split = in.split(" ");
            int[] res = new int[split.length];
            for (int i = 0; i < split.length; i++) {
                res[i] = Integer.parseInt(split[i]);
            }
            boolean[] isValid = new boolean[split.length];
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            dfs(res,ans,temp,n,isValid,0,1);
            System.out.println(ans.size());
        }
    }

    private static void dfs(int[] res, List<List<Integer>> ans, List<Integer> temp, int n, boolean[] isValid, int index,int all) {
        if(index >= n){
            return;
        }
        for (int i = index; i < n; i++) {
            if(i>0 && res[i] == res[i-1] && !isValid[i-1]){
                continue;
            }
            all = all * res[i];
            temp.add(res[i]);
            isValid[i] = true;
            if(all == 1){
                ans.add(new ArrayList<>(temp));
            }
            dfs(res,ans,temp,n,isValid,i+1,all);
            all = all / res[i];
            temp.remove(temp.size()-1);
            isValid[i] = false;
        }
    }
}
