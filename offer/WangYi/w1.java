package offer.WangYi;

import java.util.*;

public class w1 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while(cin.hasNextLine()) {
            String line = cin.nextLine();
            String[] lines = line.split(",");
            int total = lines.length;
            int sum = total;
            List<List<Integer>> list = new ArrayList<>();
            for (String item : lines){
                item = item.replace("[","").replace("]","");
                String[] nums =item.split(",");
                List<Integer> temp = new ArrayList<>();
                for (String num:nums){
                    if("".equals(num)){
                        list.add(new ArrayList<>());
                    }else {
                        temp.add(Integer.parseInt(num));
                        list.add(temp);
                    }
                }
            }
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < total; i++) {
                set.add(i);
            }
            dfs(set,0,list,sum);
            System.out.println(set.isEmpty());
        }
    }

    private static void dfs(Set<Integer> set, int index, List<List<Integer>> list,int sum) {
        if(!set.contains(index) || sum == 0){
            return;
        }
        set.remove(index);
        List<Integer> items = list.get(index);
        for (int i = 0; i < items.size(); i++) {
            dfs(set, items.get(i), list,sum-1);
        }
    }
}
