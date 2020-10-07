package cn.edu.nju.leetcode.problems;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/10/7
 */
public class LeetCode1312 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minInsertions("zzazz"));
        System.out.println(solution.minInsertions("mbadm"));
        System.out.println(solution.minInsertions("leetcode"));
        System.out.println(solution.minInsertions("g"));
        System.out.println(solution.minInsertions("no"));
    }

    /**
     * 动态规划
     * dp[i][j] 表示 i,...,j 长度的字符串称为回文串的最少操作次数
     * <p>
     * 同类型：
     * 5. 最长回文子串
     * 516. 最长回文子序列
     */
    static class Solution {
        public int minInsertions(String s) {
            if (s == null || s.length() == 0) return 0;
            int len = s.length();
            int[][] dp = new int[len][len];
            // 对角线上 i==j，操作次数为 0，默认为 0
            for (int i = len - 2; i >= 0; i--) {
                for (int j = i + 1; j < len; j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1];
                    } else {
                        dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                    }
                }
            }
            return dp[0][len - 1];
        }
    }
}
