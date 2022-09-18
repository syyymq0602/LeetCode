import java.util.ArrayList;
import java.util.List;

public class q10 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,4,2,3};
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(ans,temp,visited,nums);
        for (List<Integer> item : ans){
            System.out.println(item.toString());
        }
    }

    private static void dfs(List<List<Integer>> ans, List<Integer> temp, boolean[] visited, int[] nums) {
        if(temp.size() == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(visited[i]){
                continue;
            }
            temp.add(nums[i]);
            visited[i] = true;
            dfs(ans,temp,visited,nums);
            temp.remove(temp.size()-1);
            visited[i] = false;
        }
    }
}

class Single {
    private volatile static Single single;

    private Single(){

    }

    public static Single getInstance(){
        if(single == null){
            synchronized (Single.class){
                if(single == null){
                    single = new Single();
                }
            }
        }
        return single;
    }
}
