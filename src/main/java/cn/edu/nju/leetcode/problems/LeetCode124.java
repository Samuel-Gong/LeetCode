package cn.edu.nju.leetcode.problems;

import cn.edu.nju.leetcode.structure.TreeNode;

/**
 * 二叉树中的最大路径和
 * 给定一个非空二叉树，返回其最大路径和。
 * <p>
 * 本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 * <p>
 * 注意：节点不能重复利用，即从某一节点作为起点，只能有一条路径连接左子树的一个节点，否则就重复利用了左节点。右子树同理
 * <p>
 *
 * @author Shenmiu
 * @date 2020/10/8
 */
public class LeetCode124 {
    static class Solution {
        int res = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            int rootMax = maxGain(root);
            return Math.max(res, rootMax);
        }

        private int maxGain(TreeNode root) {
            // 空节点的贡献值为 0
            if (root == null) return 0;
            // 递归计算左右子节点的最大贡献值
            // 只有在最大贡献值大于 0 时，才会选取对应子节点
            int leftGain = Math.max(maxGain(root.left), 0);
            int rightGain = Math.max(maxGain(root.right), 0);

            // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
            int priceNewpath = root.val + leftGain + rightGain;

            // 更新答案
            res = Math.max(res, priceNewpath);

            // 包含当前节点路径的贡献为当前节点值 + Math.max(leftGain, rightGain)
            return root.val + Math.max(leftGain, rightGain);
        }
    }
}
