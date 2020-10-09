package cn.edu.nju.leetcode.剑指offer;

import cn.edu.nju.leetcode.structure.TreeNode;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/10/9
 */
public class Problem54 {

    /**
     * 二叉搜索树的第 k 大节点
     * 二叉搜索树的重要性质：中序遍历的结果是由小到大排序好的
     * <p>
     * 可推知，中序遍历的倒序是由大到小排序好的，第 k 个值就是所求结果
     * 中序遍历：左->根->右
     * 中序倒序：右->根->左
     */
    static class Solution {
        int k;
        int res;

        public int kthLargest(TreeNode root, int k) {
            this.k = k;
            dfs(root);
            return res;
        }

        private void dfs(TreeNode node) {
            if (node == null) return;
            if (k == 0) return;
            dfs(node.right);
            // 每次访问根时就将 k-1
            k--;
            // 当 k 减为 0 时，当前节点值就是第 k 大的值
            if (k == 0) {
                res = node.val;
                return;
            }
            dfs(node.left);
        }
    }
}
