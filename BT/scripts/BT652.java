package BT.scripts;

import java.util.*;

/**
 * 652. 寻找重复的子树
 *
 * 给定一棵二叉树 root，返回所有重复的子树。
 * 对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 * 如果两棵树具有相同的结构和相同的结点值，则它们是重复的
 *
 * 树中的结点数在[1,10^4]范围内。
 * -200 <= Node.val <= 200
 */
public class BT652 {
    public static void main(String[] args) {
        var node = TreeNodeUtils.generateByList(Arrays.asList(1,2,3,4,null,2,4,null,null,4));
        for (var n : findDuplicateSubtrees(node)){
            System.out.println(TreeNodeUtils.ListNodeToString(n));
        }
    }

    private static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String,TreeNode> map = new HashMap<>();
        Set<TreeNode> set = new HashSet<>();
        dfs(root,map,set,true);
        return new ArrayList<>(set);
    }

    private static String dfs(TreeNode root, Map<String, TreeNode> map, Set<TreeNode> set,boolean flag) {
        if(root == null){
            if(flag){
                return "l";
            }
            return "r";
        }
        StringBuilder builder = new StringBuilder();
        builder.append(dfs(root.left,map,set,true));
        builder.append(root.val);
        builder.append(dfs(root.right,map,set,false));
        String key = builder.toString();
        if(!map.containsKey(key)){
            map.put(key,root);
        }else {
            set.add(map.get(key));
        }
        return key;
    }
}
