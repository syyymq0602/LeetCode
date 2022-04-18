package offer.special;

import java.util.*;

/**
 * 剑指 Offer II 033. 变位词组
 *
 * 给定一个字符串数组 strs ，将 变位词 组合在一起。 可以按任意顺序返回结果列表。
 * 注意：若两个字符串中每个字符出现的次数都相同，则称它们互为变位词
 *
 * 1 <= strs.length <= 10e4
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 */
public class O033 {
    public static void main(String[] args) {
        var ans = groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        for (var item:ans) {
            System.out.println(item.toString());
        }
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        int index = 1;
        for (int i = 0; i < strs.length; i++) {
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String base = new String(charArray);
            if(!map.containsKey(base)){
                map.put(base,index);
                index++;
                List<String> item = new ArrayList<>();
                item.add(strs[i]);
                ans.add(item);
            }else {
                Integer pos = map.get(base)-1;
                ans.get(pos).add(strs[i]);
            }
        }
        return ans;
    }
}
