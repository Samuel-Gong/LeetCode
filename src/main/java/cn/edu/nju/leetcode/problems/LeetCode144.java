package cn.edu.nju.leetcode.problems;

import cn.edu.nju.leetcode.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/10/8
 */
public class LeetCode144 {
    /**
     * 前序遍历非递归实现
     */
    static class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            Deque<TreeNode> stack = new ArrayDeque<>();
            TreeNode cur = root;
            // 注意循环条件
            while (cur != null || !stack.isEmpty()) {
                while (cur != null) {
                    // 第一次访问节点，将节点的值加入结果集，继续访问左子节点
                    res.add(cur.val);
                    stack.push(cur);
                    cur = cur.left;
                }
                // 第二次访问节点，左子树访问完毕，访问右子节点
                cur = stack.pop();
                cur = cur.right;
            }
            return res;
        }
    }
}
