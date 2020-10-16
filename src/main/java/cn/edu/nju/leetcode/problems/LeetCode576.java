package cn.edu.nju.leetcode.problems;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/10/16
 */
public class LeetCode576 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findPaths(2, 2, 2, 0, 0));
    }

    /**
     * 动态规划
     * https://leetcode-cn.com/problems/out-of-boundary-paths/solution/zhuang-tai-ji-du-shi-zhuang-tai-ji-by-christmas_wa/
     * <p>
     * dp[i][j][k]: 表示从 (i,j) 出发第 k 步出界的路径总数
     * 状态转移：(i,j) 可以向四个方向走，则 dp[i][j][k] = dp[i-1][j][k-1] + dp[i+1][j][k-1] + dp[i][j+1][k-1] + dp[i][j-1][k+1]
     */
    static class Solution {
        int mod = 1000000007;

        public int findPaths(int m, int n, int N, int i, int j) {
            if (N == 0) return 0;
            int[][][] dp = new int[m + 2][n + 2][N + 1];
            // 第 0 列：表示左界外
            // 第 n+1 列：表示右界外
            for (int r = 0; r <= m + 1; r++) {
                dp[r][0][0] = 1;
                dp[r][n + 1][0] = 1;
            }
            // 第 0 行： 表示上界外
            // 第 m+1 行：表示下界外
            for (int c = 0; c <= n + 1; c++) {
                dp[0][c][0] = 1;
                dp[m + 1][c][0] = 1;
            }
            for (int k = 1; k <= N; k++) {
                for (int r = 1; r <= m; r++) {
                    for (int c = 1; c <= n; c++) {
                        dp[r][c][k] = ((dp[r - 1][c][k - 1] % mod + dp[r + 1][c][k - 1] % mod) % mod +
                                +(dp[r][c + 1][k - 1] % mod + dp[r][c - 1][k - 1] % mod) % mod) % mod;
                    }
                }
            }
            int sum = 0;
            for (int k = 1; k <= N; k++) {
                sum = (sum % mod + dp[i + 1][j + 1][k] % mod) % mod;
            }
            return sum;
        }
    }
}
