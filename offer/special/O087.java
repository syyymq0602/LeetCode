package offer.special;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer II 087. 复原 IP
 *
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能从s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址
 *
 * 0 <= s.length <= 3000
 * s 仅由数字组成
 */
public class O087 {
    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135"));
    }

    private static List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        int n = s.length();
        if(n < 4 || n > 12){
            return ans;
        }
        List<String> path = new ArrayList<>();
        dfs(ans,s,path,0,0);
        return ans;
    }

    private static void dfs(List<String> ans, String s, List<String> path, int pos, int level) {
        if(level == 4){
            ans.add(String.join(".",path));
            return;
        }
        for (int i = pos; i < s.length(); i++) {
            if(s.length() - 1 - i > 3 * (3-level)){
                continue;
            }
            if(!validIp(s.substring(pos,i+1))){
                continue;
            }
            path.add(s.substring(pos,i+1));
            dfs(ans,s,path,i+1,level+1);
            path.remove(path.size()-1);
        }
    }

    private static boolean validIp(String substring) {
        int len = substring.length();
        if(substring.charAt(0) == '0' && len > 1){
            return false;
        }
        if(len > 3){
            return false;
        }
        if(Integer.parseInt(substring) > 255){
            return false;
        }
        return true;
    }
}
