package cn.edu.nju.leetcode.problems;

import cn.edu.nju.leetcode.structure.TreeNode;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/9/28
 */
public class Assignment563 {
    static class Solution {
        int res = 0;

        public int findTilt(TreeNode root) {
            sum(root);
            return res;
        }

        private int sum(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = sum(root.left);
            int right = sum(root.right);
            res += Math.abs(left - right);
            return root.val + left + right;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode n1 = new TreeNode(1);
        n1.left = new TreeNode(2);
        System.out.println(solution.findTilt(n1));
    }
}
