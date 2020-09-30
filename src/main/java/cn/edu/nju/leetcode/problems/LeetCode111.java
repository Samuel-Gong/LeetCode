package cn.edu.nju.leetcode.problems;

import cn.edu.nju.leetcode.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/9/30
 */
public class LeetCode111 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minDepth(TreeNode.ofArray(new Integer[]{3, 9, 20, null, null, 15, 7})));
    }

    static class Solution {
        public int minDepth(TreeNode root) {
            if (root == null) return 0;
            Deque<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            TreeNode cur;
            int depth = 0;
            while (!queue.isEmpty()) {
                int curLevelSize = queue.size();
                depth += 1;
                for (int i = 0; i < curLevelSize; i++) {
                    cur = queue.poll();
                    if (cur.left == null && cur.right == null) return depth;
                    if (cur.left != null) queue.offer(cur.left);
                    if (cur.right != null) queue.offer(cur.right);
                }
            }
            return depth;
        }
    }
}
