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
 * @date 2019/10/9
 */
public class Assignment863 {
    static class Solution {
        public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
            List<Integer> res = new ArrayList<>();
            int depth = find(root, target);
            distanceK(root, depth, K, 0, res);
            return res;
        }

        private int find(TreeNode root, TreeNode target) {
            Deque<TreeNode> deque = new ArrayDeque<>();
            TreeNode cur = root;
            int depth = 0;
            while (cur != null) {
                deque.push(cur);
                depth++;
                cur = cur.left;
            }

            while (!deque.isEmpty() || cur != null) {
                if (cur != null) {
                    if (cur.val == target.val) {
                        return depth;
                    }
                    if (cur.right != null) {
                        cur = cur.right;
                    }
                    while (cur != null) {
                        deque.push(cur);
                        depth++;
                        cur = cur.left;
                    }
                }
                cur = deque.pop();
                depth--;
            }

            return depth;
        }

        private void distanceK(TreeNode root, int target, int K, int cur, List<Integer> res) {
            if (root == null) {
                return;
            }
            if (Math.abs(root.val - target) == K) {
                res.add(root.val);
                return;
            } else {
                distanceK(root.left, target, K, cur + 1, res);
                distanceK(root.right, target, K, cur + 1, res);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.distanceK(TreeNode.ofArray(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4}), new TreeNode(5), 2));
    }
}
