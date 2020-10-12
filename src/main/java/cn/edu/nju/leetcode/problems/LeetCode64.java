package cn.edu.nju.leetcode.problems;

import java.util.Arrays;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/10/12
 */
public class LeetCode64 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minPathSum(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        }));
    }

    /**
     * dp 解题
     */
    static class Solution {
        public int minPathSum(int[][] grid) {
            if (grid == null || grid.length == 0) return 0;
            int m = grid.length;
            int n = grid[0].length;
            int[][] dp = new int[m + 1][n + 1];
            Arrays.fill(dp[0], Integer.MAX_VALUE);
            for (int i = 0; i < m + 1; i++) {
                dp[i][0] = Integer.MAX_VALUE;
            }
            dp[0][0] = 0;
            dp[0][1] = 0;
            dp[1][0] = 0;
            for (int i = 1; i < m + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
                }
            }
            return dp[m][n];
        }
    }
}
