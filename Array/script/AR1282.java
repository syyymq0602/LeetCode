package Array.script;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1282. 用户分组
 *
 * 有n个人被分成数量未知的组。每个人都被标记为一个从 0 到 n - 1 的唯一ID。
 * 给定一个整数数组 groupSizes ，其中groupSizes[i]是第 i 个人所在的组的大小。
 * 例如，如果groupSizes[1] = 3，则第 1 个人必须位于大小为 3 的组中。
 * 返回一个组列表，使每个人 i 都在一个大小为groupSizes[i]的组中。
 * 每个人应该恰好只出现在一个组中，并且每个人必须在一个组中。如果有多个答案，返回其中任何一个。可以保证给定输入至少有一个有效的解
 *
 * groupSizes.length == n
 * 1 <= n <= 500
 * 1 <= groupSizes[i] <= n
 */
public class AR1282 {
    public static void main(String[] args) {
        var ans = groupThePeople(new int[]{2,1,3,3,3,2});
        for (var item : ans){
            System.out.println(item.toString());
        }
    }

    private static List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer,List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            if(!map.containsKey(groupSizes[i])){
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                if(temp.size() == groupSizes[i]){
                    ans.add(temp);
                }else {
                    map.put(groupSizes[i],temp);
                }
            }else {
                List<Integer> group = map.get(groupSizes[i]);
                group.add(i);
                if(group.size() == groupSizes[i]){
                    ans.add(group);
                    map.put(groupSizes[i], new ArrayList<>());
                }
            }
        }
        return ans;
    }
}
