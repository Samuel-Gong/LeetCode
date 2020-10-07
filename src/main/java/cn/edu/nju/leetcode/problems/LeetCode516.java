package cn.edu.nju.leetcode.problems;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/9/30
 */
public class LeetCode516 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindromeSubseq("bbbab"));
    }

    /**
     * 使用动态规划解决，可以结合 LeetCode5，最长回文子串来看
     */
    static class Solution {
        public int longestPalindromeSubseq(String s) {
            if (s == null || s.length() == 0) return 0;
            int len = s.length();
            // dp[i][j] 表示 i...j 长度的字符串的最长回文子序列的长度
            // 故只需要计算 dp 二维数组的右上角的部分，即 j >= i 的部分
            int[][] dp = new int[len][len];
            // 对角线上 i==j，为回文子序列，长度为 1
            for (int i = 0; i < s.length(); i++) {
                dp[i][i] = 1;
            }

            // 因为 dp[i][j] 依赖 dp[i][j-1], dp[i+1][j], dp[i+1][j-1] 的值，要使得无后效性
            // 则遍历顺序需要从下往上，从左往右遍历
            for (int i = len - 2; i >= 0; i--) {
                for (int j = i + 1; j < len; j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        // 两侧字符相同时，i, i+1, ... , j-1, j 的最长子序列为 i+1,...,j-1 的最长子序列 + 2
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        // 不同时，i,i+1,...j-1,j 的最长子序列为 i,...j-1 和 i+1,...j 之间的最大值
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                    }
                }
            }
            return dp[0][len - 1];
        }
    }
}
