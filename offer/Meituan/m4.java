package offer.Meituan;

import java.util.*;

public class m4 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()) {
            int n = cin.nextInt();
            int k = cin.nextInt();
            int[] nums = new int[n];
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                nums[i] = cin.nextInt();
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
            Map<Integer,Integer> mem = new HashMap<>();
            for (int i = 1; i <= k; i++) {
                Integer count = map.get(i);
                int all = count / 2 + count % 2;
                mem.put(i,all);
            }
            List<Integer> xunlian = new ArrayList<>();
            List<Integer> ceshi = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if(mem.get(nums[i]) != 0){
                    xunlian.add(i+1);
                    mem.put(nums[i], mem.get(nums[i])-1);
                }else {
                    ceshi.add(i+1);
                }
            }
            StringBuilder xl = new StringBuilder();
            StringBuilder cs = new StringBuilder();
            for (int i = 0; i < xunlian.size(); i++) {
                xl.append(xunlian.get(i)).append(" ");
            }
            System.out.println(xl.toString().trim());
            for (int i = 0; i < ceshi.size(); i++) {
                cs.append(ceshi.get(i)).append(" ");
            }
            System.out.println(cs.toString().trim());
        }
    }
}
