package offer.JingDong;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class j2 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()) {
            int n = cin.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = cin.nextInt();
            }
            Map<Integer, Integer> jishu = new HashMap<>();
            Map<Integer, Integer> oushu = new HashMap<>();
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    oushu.put(nums[i], oushu.getOrDefault(nums[i], 0) + 1);
                } else {
                    jishu.put(nums[i], jishu.getOrDefault(nums[i], 0) + 1);
                }
            }
            int jiMax = 0;
            int ouMax = 0;
            int jiCount = 0;
            int ouCount = 0;
            for (Map.Entry<Integer, Integer> entry : oushu.entrySet()) {
                if (entry.getValue() > ouCount) {
                    ouCount = entry.getValue();
                    ouMax = entry.getKey();
                }
            }
            for (Map.Entry<Integer, Integer> entry : jishu.entrySet()) {
                if (entry.getValue() > jiCount) {
                    jiCount = entry.getValue();
                    jiMax = entry.getKey();
                }
            }
            if (jiMax != ouMax) {
                System.out.println(n - jiCount - ouCount);
            } else {
                // 奇偶相等
                int jiSecond = 0;
                int ouSecond = 0;
                for (Map.Entry<Integer, Integer> entry : oushu.entrySet()) {
                    if (entry.getKey() == ouMax) {
                        continue;
                    }
                    if (entry.getValue() > ouSecond) {
                        ouSecond = entry.getValue();
                    }
                }
                {
                    for (Map.Entry<Integer, Integer> entry : jishu.entrySet()) {
                        if (entry.getKey() == jiMax) {
                            continue;
                        }
                        if (entry.getValue() > jiSecond) {
                            jiSecond = entry.getValue();
                        }
                    }
                }
                int max = Math.max(jiCount + ouSecond,ouCount+jiSecond);
                System.out.println(n - max);
            }
        }
    }
}
