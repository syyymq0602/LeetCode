package BT.scripts;

import java.util.HashMap;
import java.util.Map;

/**
 * 654. 最大二叉树
 *
 * 给定一个不重复的整数数组nums 。最大二叉树可以用下面的算法从nums 递归地构建:
 * 创建一个根节点，其值为nums 中的最大值。
 * 递归地在最大值左边的子数组前缀上构建左子树。
 * 递归地在最大值 右边 的子数组后缀上构建右子树。
 * 返回nums 构建的 最大二叉树 。
 *
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 1000
 * nums 中的所有整数 互不相同
 */
public class BT654 {
    public static void main(String[] args) {
        var node = constructMaximumBinaryTree(new int[]{3,2,1,6,0,5});
        System.out.println(TreeNodeUtils.ListNodeToString(node));
    }

    static Map<Integer,Integer> map;

    private static TreeNode constructMaximumBinaryTree(int[] nums) {
        int n = nums.length;
        map = new HashMap<>();
        TreeNode node = dfs(nums,0,n-1);
        return node;
    }

    private static TreeNode dfs(int[] nums, int start, int end) {
        if(start > end || map.size() == nums.length){
            return null;
        }
        int maxNum = getMaxNum(nums,start,end);
        int index = map.get(maxNum);
        TreeNode node = new TreeNode(maxNum);
        node.left = dfs(nums,start,index-1);
        node.right = dfs(nums,index+1,end);
        return node;
    }

    private static int getMaxNum(int[] nums,int start,int end){
        int max = -1;
        int index = -1;
        for (int i = start; i <= end; i++) {
            if(nums[i] > max){
                max = nums[i];
                index = i;
            }
        }
        map.put(max,index);
        return max;
    }
}
