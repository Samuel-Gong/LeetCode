package cn.edu.nju.leetcode.problems;

import cn.edu.nju.leetcode.structure.TreeNode;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/10/11
 */
public class LeetCode1022 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sumRootToLeaf(TreeNode.ofArray(new Integer[]{1, 0, 1, 0, 1, 0, 1})));
    }

    /**
     * dfs
     */
    static class Solution {
        int res = 0;
        int mod = 1000000007;

        public int sumRootToLeaf(TreeNode root) {
            dfs(root, 0);
            return res;
        }

        private void dfs(TreeNode node, int cur) {
            cur = (cur << 1) + node.val;
            if (node.left == null && node.right == null) {
                res = ((res % mod) + (cur % mod)) % mod;
                return;
            }
            if (node.left != null) dfs(node.left, cur);
            if (node.right != null) dfs(node.right, cur);
        }
    }
}
