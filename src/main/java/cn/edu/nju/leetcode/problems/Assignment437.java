package cn.edu.nju.leetcode.problems;

import cn.edu.nju.leetcode.structure.TreeNode;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/10/12
 */
public class Assignment437 {
    static class Solution {
        public int pathSum(TreeNode root, int sum) {
            return path(root, sum, 0);
        }

        int path(TreeNode root, int sum, int cur) {
            if (root == null) {
                return 0;
            }
            int cnt = 0;
            if (cur + root.val == sum) {
                cnt++;
            }
            int left1 = path(root.left, sum, root.val);
            int left2 = path(root.left, sum, cur + root.val);
            int right1 = path(root.right, sum, root.val);
            int right2 = path(root.right, sum, cur + root.val);

            return left1 + left2 + right1 + right2 + cnt;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.pathSum(TreeNode.ofArray(new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1}), 8));
    }

}
