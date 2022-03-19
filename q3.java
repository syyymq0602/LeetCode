import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class q3 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while(cin.hasNextLine()) {
            String line = cin.nextLine();
            String[] s = line.split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int index = 0;
            List<String> list = new ArrayList<>();
            while (index < n){
                String in = cin.nextLine();
                list.add(in);
                index++;
            }
            boolean[] isValid = new boolean[m+1];
            List<List<String>> ans = new ArrayList<>();
            List<String> temp = new ArrayList<>();
            dfs(list,ans,temp,isValid,n,0);
            int max = -1;
            for (int i = 0; i < ans.size(); i++) {
                max = Math.max(ans.get(i).size(),max);
            }
            System.out.println(max);
        }
    }

    private static void dfs(List<String> list, List<List<String>> ans, List<String> temp, boolean[] isValid, int n,int index) {
        if(index == n){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < n; i++) {
            int first = Integer.parseInt(list.get(i).split(" ")[0]);
            int second = Integer.parseInt(list.get(i).split(" ")[1]);
            if(!isValid[first] && !isValid[second]){
                temp.add(list.get(i));
                isValid[first] = true;
                isValid[second] = true;
                dfs(list,ans,temp,isValid,n,i+1);
                isValid[first] = false;
                isValid[second] = false;
                temp.remove(temp.size()-1);
            }
        }
    }

}
