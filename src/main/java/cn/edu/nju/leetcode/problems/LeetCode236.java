package cn.edu.nju.leetcode.problems;

import cn.edu.nju.leetcode.structure.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 二叉树的最近公共祖先
 * <p>
 *
 * @author Shenmiu
 * @date 2020/7/14
 */
public class LeetCode236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        return lowestCommonAncestorRecursive(root, p, q);
        Solution solution = new Solution();
        return solution.lowestCommonAncestor(root, p, q);
    }

    /**
     * 非递归方法
     * 保存父子节点的关系，回溯祖先
     */
    static class Solution {
        // 保存整个树中父子节点关系，key 为子结点，value 为父结点
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        // 保存选定目标点的所有祖先
        Set<TreeNode> ancestors = new HashSet<>();

        private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) return null;
            dfs(root);
            // 这里选择的是将 p 点作为目标点，ancestors 保存的是从 p 到根节点路径上，所有 p 的祖先
            while (parents.containsKey(p)) {
                ancestors.add(p);
                p = parents.get(p);
            }
            // 退出循环的条件为 ancestors.contains(q)
            // 而 ancestors 中保存的是 p 的所有祖先，则说明当前 q 是 LCA
            while (!ancestors.contains(q)) {
                q = parents.get(q);
            }
            return q;
        }

        private void dfs(TreeNode root) {
            if (root == null) return;
            if (root.left != null) {
                parents.put(root.left, root);
                dfs(root.left);
            }
            if (root.right != null) {
                parents.put(root.right, root);
                dfs(root.right);
            }
        }
    }

    /**
     * 递归方法
     * 通过判断根节点、左右子树的状态来判断公共祖先
     */
    static class Solution2 {
        TreeNode res = null;

        private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            helper(root, p, q);
            return res;
        }

        private boolean helper(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) return false;
            boolean cur = false;
            if (root == p || root == q) {
                cur = true;
            }
            boolean inleft = helper(root.left, p, q);
            boolean inright = helper(root.right, p, q);
            // 该条件表示，p,q 恰好分布在当前节点，左子树，右子树中的两个区域，则当前节点为最近公共祖先，记录结果即可
            if ((cur && inleft) || (cur && inright) || (inleft && inright)) {
                res = root;
                return true;
            } else {
                return cur || inleft || inright;
            }
        }
    }
}
