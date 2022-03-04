package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. 复原 IP 地址
 *
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 *
 * 1 <= s.length <= 20
 * s 仅由数字组成
 */
public class BT93 {
    public static void main(String[] args) {
        var s = "25525511135";
        List<String> addresses = restoreIpAddresses(s);
        for (var addr:addresses) {
            System.out.println(addr);
        }
    }

    private static List<String> restoreIpAddresses(String s) {
        List<String> ans =new ArrayList<>();
        if(s.length()<4 || s.length()>12){
            return ans;
        }
        List<String> path = new ArrayList<>();
        dfs(ans,path,s,0,0);
        return ans;
    }

    private static void dfs(List<String> ans, List<String> path, String s, int splitIndex, int level) {
        if(level == 4){
            ans.add(String.join(".",path));
            return;
        }
        for (int i = splitIndex; i < s.length(); i++) {
            if((s.length()-1-i)>3*(3-level)){
                continue;
            }
            if(!isValidIp(s.substring(splitIndex,i+1))){
                continue;
            }
            //把合法的IP地址段加入path存储
            path.add(s.substring(splitIndex,i+1));
            //每次把分割线往后移一位，且段数level+1
            dfs(ans,path,s,i+1,level+1);
            //进行回溯操作
            path.remove(path.size()-1);
        }
    }

    private static boolean isValidIp(String s) {
        //判断其是否含有前导0
        if(s.charAt(0)=='0' && s.length()>1){
            return false;
        }
        //长度为4就直接舍弃，加上这一步是为了后面parseInt做准备,防止超过了Integer可以表示的整数范围
        if(s.length()>3){
            return false;
        }
        //将字符转为int判断是否大于255，因为题目明确说了只由数字组成，所以这里没有对非数字的字符进行判断
        if(Integer.parseInt(s)>255){
            return false;
        }
        return true;
    }
}
