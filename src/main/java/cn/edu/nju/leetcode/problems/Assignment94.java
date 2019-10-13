package cn.edu.nju.leetcode.problems;

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
public class Assignment94 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            Deque<TreeNode> stack = new ArrayDeque<>();
            List<Integer> inorder = new ArrayList<>();

            TreeNode x = root;
            while (x != null || !stack.isEmpty()) {
                if (null != x) {
                    stack.push(x);
                    x = x.left;
                } else {
                    x = stack.pop();
                    inorder.add(x.val);
                    x = x.right;
                }
            }
            return inorder;
        }
    }

}
