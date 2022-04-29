package offer.special;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 剑指 Offer II 061. 和最小的 k 个数对
 *
 * 给定两个以升序排列的整数数组 nums1 和 nums2,以及一个整数 k。
 * 定义一对值(u,v)，其中第一个元素来自nums1，第二个元素来自 nums2。
 * 请找到和最小的 k个数对(u1,v1), (u2,v2) ... (uk,vk)
 *
 * 1 <= nums1.length, nums2.length <= 10e4
 * -10e9 <= nums1[i], nums2[i] <= 10e9
 * nums1, nums2 均为升序排列
 * 1 <= k <= 1000
 */
public class O061 {
    public static void main(String[] args) {
        var n1 = new int[]{1,7,11};
        var n2 = new int[]{2,4,6};
        for (var item: kSmallestPairs(n1,n2,3)) {
            System.out.println(item.toString());
        }
    }

    private static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(k,
                (o1,o2)-> nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]]);
        List<List<Integer>> ans = new ArrayList<>();
        int n1 = nums1.length;
        int n2 = nums2.length;
        for (int i = 0; i < Math.min(n1,k); i++) {
            pq.offer(new int[]{i,0});
        }
        while (k-- > 0 && !pq.isEmpty()){
            int[] idxPair = pq.poll();
            List<Integer> list = new ArrayList<>();
            list.add(nums1[idxPair[0]]);
            list.add(nums2[idxPair[1]]);
            ans.add(list);
            if(idxPair[1] + 1 < n2){
                pq.offer(new int[]{idxPair[0],idxPair[1]+1});
            }
        }

        return ans;
    }
}
