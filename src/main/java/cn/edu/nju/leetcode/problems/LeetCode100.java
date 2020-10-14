package cn.edu.nju.leetcode.problems;

import cn.edu.nju.leetcode.structure.TreeNode;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/10/14
 */
public class LeetCode100 {

    static class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) return true;
            if (p == null || q == null) return false;
            return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
