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
 * @date 2019/9/28
 */
public class LeetCode145 {
    /**
     * 非递归实现
     */
    static class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            Deque<TreeNode> stack = new ArrayDeque<>();
            TreeNode cur = root;
            // 用于记录上一个加入到结果集中的节点
            TreeNode lastVisit = null;
            while (cur != null || !stack.isEmpty()) {
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
                cur = stack.pop();
                // cur.right == null 表示第二次访问该节点时，该节点无右子树，直接添加到结果集
                // cur.right.equals(lastVisit) 表示第三次访问该结点时，将该节点添加到结果集
                if (cur.right == null || cur.right.equals(lastVisit)) {
                    // 更新结果集，同时更新 lastVisit
                    res.add(cur.val);
                    lastVisit = cur;
                    // 当前节点更新为空
                    cur = null;
                } else {
                    // 不符合判断条件，说明要先访问右子树，把当前节点压栈，准备第三次访问
                    stack.push(cur);
                    cur = cur.right;
                }
            }
            return res;
        }
    }
}
