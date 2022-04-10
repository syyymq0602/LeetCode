package BT.scripts;

import java.util.LinkedList;
import java.util.List;

public class TreeNodeUtils {
    public static TreeNode generateByList(List<Integer> numsList) {
        var n = numsList.size();
        var index = 0;
        var root = new TreeNode(numsList.get(0));
        Integer value;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (index < n) {
            var temp = queue.poll();
            if(++index == n){
                break;
            }
            value = numsList.get(index);
            if (value != null) {
                var left = new TreeNode(value);
                temp.left = left;
                queue.offer(left);
            }
            if(++index == n){
                break;
            }
            value = numsList.get(index);
            if (value != null) {
                var right = new TreeNode(value);
                temp.right = right;
                queue.offer(right);
            }
        }
        return root;
    }
}
