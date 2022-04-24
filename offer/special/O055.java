package offer.special;

import BT.scripts.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 剑指 Offer II 055. 二叉搜索树迭代器
 *
 * 实现一个二叉搜索树迭代器类BSTIterator ，表示一个按中序遍历二叉搜索树（BST）的迭代器：
 *
 * BSTIterator(TreeNode root) 初始化 BSTIterator 类的一个对象。BST 的根节点 root 会作为构造函数的一部分给出。
 * 指针应初始化为一个不存在于 BST 中的数字，且该数字小于 BST 中的任何元素。
 * boolean hasNext() 如果向指针右侧遍历存在数字，则返回 true ；否则返回 false 。
 * int next()将指针向右移动，然后返回指针处的数字。
 * 注意，指针初始化为一个不存在于 BST 中的数字，所以对 next() 的首次调用将返回 BST 中的最小元素。
 *
 * 可以假设next()调用总是有效的，也就是说，当调用 next()时，BST 的中序遍历中至少存在一个下一个数字
 *
 * 树中节点的数目在范围 [1, 10e5] 内
 * 0 <= Node.val <= 10e6
 * 最多调用 10e5 次 hasNext 和 next 操作
 */
public class O055 {
    public static void main(String[] args) {

    }

    private static class BSTIterator {
        Deque<TreeNode> stack;
        TreeNode cur;

        public BSTIterator(TreeNode root) {
            stack = new LinkedList<>();
            cur = root;
        }

        public int next() {
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            int ans = cur.val;
            cur = cur.right;
            return ans;
        }

        public boolean hasNext() {
            return cur != null || !stack.isEmpty();
        }
    }
}
