package BT.scripts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    public static String ListNodeToString(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                var n = queue.poll();
                list.add(n.val);
                if(n.left != null){
                    queue.offer(n.left);
                }
                if(n.right != null){
                    queue.offer(n.right);
                }
            }
        }
        for (int i = list.size() - 1; i >=0 ; i--) {
            if(list.get(i) == null){
                list.remove(i);
            }else {
                break;
            }
        }
        return list.toString();
    }
}
