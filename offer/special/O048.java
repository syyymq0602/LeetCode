package offer.special;

import BT.scripts.TreeNode;
import BT.scripts.TreeNodeUtils;

import java.util.*;

/**
 * 剑指 Offer II 048. 序列化与反序列化二叉树
 *
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，
 * 同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
 * 只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构
 *
 * 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅LeetCode 序列化二叉树的格式。你并非必须采取这种方式，也可以采用其他的方法解决这个问题。
 * 树中结点数在范围 [0, 10e4] 内
 * -1000 <= Node.val <= 1000
 */
public class O048 {
    public static void main(String[] args) {
        var root = TreeNodeUtils.generateByList(Arrays.asList(1,2,3,null,null,4,5));
        Codec ser = new Codec();
        Codec deser = new Codec();
        String ans1 = ser.serialize(root);
        System.out.println(ans1);
        TreeNode ans2 = deser.deserialize(ans1);
    }

    private static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(root == null){
                return " ";
            }
            List<Integer> list = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            StringBuilder builder = new StringBuilder();
            queue.offer(root);
            list.add(root.val);
            while (!queue.isEmpty()){
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode temp = queue.poll();
                    if(temp.left != null){
                        queue.offer(temp.left);
                        list.add(temp.left.val);
                    }else {
                        list.add(null);
                    }
                    if(temp.right != null){
                        queue.offer(temp.right);
                        list.add(temp.right.val);
                    }else {
                        list.add(null);
                    }
                }
            }
            int count = list.size();
            int end = -1;
            for (int i = count-1; i >= 0; i--) {
                if(list.get(i) == null){
                    list.remove(i);
                }else {
                    end = i;
                    break;
                }
            }
            for (int i = 0; i < end + 1; i++) {
                if(list.get(i) == null){
                    builder.append("null").append(" ");
                }else {
                    builder.append(list.get(i)).append(" ");
                }
            }
            return builder.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] split = data.split(" ");
            int n = split.length;
            if(n == 0){
                return null;
            }
            int index = 0;
            TreeNode root = new TreeNode(Integer.parseInt(split[0]));
            Queue<TreeNode> treeNodeQueue = new LinkedList<>();
            treeNodeQueue.offer(root);
            while (index < n){
                TreeNode tem = treeNodeQueue.poll();
                if(++index == n){
                    break;
                }
                String itemLeft = split[index];
                if(!"null".equals(itemLeft)){
                    TreeNode left = new TreeNode(Integer.parseInt(itemLeft));
                    tem.left = left;
                    treeNodeQueue.offer(left);
                }
                if(++index == n){
                    break;
                }
                String itemRight = split[index];
                if(!"null".equals(itemRight)){
                    TreeNode right = new TreeNode(Integer.parseInt(itemRight));
                    tem.right = right;
                    treeNodeQueue.offer(right);
                }
            }
            return root;
        }
    }
}
