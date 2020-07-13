package cn.edu.nju.leetcode.problems;

import cn.edu.nju.leetcode.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * @author Shenmiu
 * @date 2020/7/14
 */
public class LeetCode98 {

    public static void main(String[] args) {
        LeetCode98 solution = new LeetCode98();
        System.out.println(solution.isValidBST(TreeNode.ofArray(new Integer[]{2, 1, 3})));
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST_Inorder(root);
    }

    /**
     * 二叉搜索树的中序遍历结果应该是有序的
     */
    private boolean isValidBST_Inorder(TreeNode root) {
        if (root == null) return true;
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        // 注意这里首先要赋值为 root
        TreeNode cur = root;
        while (!queue.isEmpty() || cur != null) {
            while (cur != null) {
                queue.push(cur);
                // 一直往左
                cur = cur.left;
            }
            cur = queue.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        for (int i = 0; i < res.size() - 1; i++) {
            if (res.get(i) >= res.get(i + 1)) return false;
        }
        return true;
    }
}
