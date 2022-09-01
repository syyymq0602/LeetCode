package offer.TuHu;

import java.util.*;

public class t3 {
    public static void main(String[] args) {
        System.out.println(minimumIncompatibility(new int[]{6,3,8,1,3,1,2,2},4));
//        System.out.println(minimumIncompatibility(new int[]{5,3,3,6,3,3},3));
    }

    private static int ans;

    public static int minimumIncompatibility (int[] nums, int k) {
        // write code here
        int len = nums.length;
        int count = len / k;
//        Arrays.sort(nums);
        Map<Integer,Integer> m1 = new HashMap<>();
        for (int i = 0; i < len; i++) {
            m1.put(nums[i], m1.getOrDefault(nums[i],0)+1);
        }
        for (Integer c : m1.values()) {
            if(c > k){
                return -1;
            }
        }
        ans = Integer.MAX_VALUE;
        List<Set<Integer>> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(new HashSet<>());
        }
        dfs(list,nums,count,0);
        return ans;
    }

    private static void dfs(List<Set<Integer>> list, int[] nums, int count, int index) {
        // 分配完毕,计算最小值
        if(index == nums.length){
            int sum = 0;
            for (Set<Integer> set : list){
                int diff = getMaxDiff(set);
                sum += diff;
            }
            ans = Math.min(ans,sum);
            return;
        }
        // 加入操作
        for (Set<Integer> set : list){
            if(set.size() < count && !set.contains(nums[index])){
                set.add(nums[index]);
                ++index;
                dfs(list,nums,count,index);
                --index;
                set.remove(nums[index]);
            }
        }
    }

    private static int getMaxDiff(Set<Integer> set){
        int max = -1;
        int min = Integer.MAX_VALUE;
        for (Integer item : set) {
            if(item > max){
                max = item;
            }
            if(item < min){
                min = item;
            }
        }
        return max - min;
    }
}
