package cn.edu.nju.leetcode.problems;

import cn.edu.nju.leetcode.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * @author Shenmiu
 * @date 2019-07-24
 */
public class LeetCode94 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        root.right = second;
        second.left = new TreeNode(3);
        System.out.println(solution.inorderTraversal(root));
    }

    /**
     * 非递归实现
     */
    static class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            Deque<TreeNode> stack = new ArrayDeque<>();
            TreeNode cur = root;
            while (cur != null || !stack.isEmpty()) {
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
            return res;
        }
    }

}
