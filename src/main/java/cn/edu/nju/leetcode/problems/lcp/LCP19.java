package cn.edu.nju.leetcode.problems.lcp;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/10/1
 */
public class LCP19 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumOperations("yry"));
        System.out.println(solution.minimumOperations("rryryryyyrrryrr"));

        Solution1 solution1 = new Solution1();
        System.out.println(solution1.minimumOperations("yry"));
        System.out.println(solution1.minimumOperations("rryryryyyrrryrr"));
    }

    /**
     * 通过前缀和解决
     */
    static class Solution {
        public int minimumOperations(String leaves) {
            int len = leaves.length();
            // 表示第 i 个位置，左边和右边分别有多少 y，包括当前位置
            int[] ly = new int[len + 1];
            int[] ry = new int[len + 1];
            char c;
            for (int i = 0; i < len; i++) {
                c = leaves.charAt(i);
                if (c == 'r') ly[i + 1] = ly[i];
                else ly[i + 1] = ly[i] + 1;
            }
            for (int i = len - 1; i >= 0; i--) {
                c = leaves.charAt(i);
                if (c == 'r') ry[i] = ry[i + 1];
                else ry[i] = ry[i + 1] + 1;
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < len - 2; i++) {
                for (int j = i + 2; j < len; j++) {
                    int leftY = ly[i + 1];
                    int rightY = ry[j];
                    int midR = j - i - 1 - (ly[j] - ly[i + 1]);
                    min = Math.min(leftY + rightY + midR, min);
                }
            }
            return min;
        }
    }

    /**
     * 动态规划
     * 两个状态: 1. 0...i 的字符串 2. j 表示字符状态，前红(j=0)，中黄(j=1)，后红(j=2)
     * dp[i][j] 表示 0...i 的字符串，将第 i 个字符状态调整为 j 时需要的最小次数
     */
    static class Solution1 {
        public int minimumOperations(String leaves) {
            int len = leaves.length();
            // dp[i][j] 表示
            int[][] dp = new int[len][3];
            // 初始化
            dp[0][0] = leaves.charAt(0) == 'r' ? 0 : 1;
            // i < j 时，不可能构成合法的字符串
            dp[0][1] = dp[0][2] = dp[1][2] = Integer.MAX_VALUE;
            for (int i = 1; i < len; i++) {
                // 前红
                dp[i][0] = dp[i - 1][0] + (leaves.charAt(i) == 'r' ? 0 : 1);
                // 中黄
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + (leaves.charAt(i) == 'y' ? 0 : 1);
                // 后红
                if (i >= 2) dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][2]) + (leaves.charAt(i) == 'r' ? 0 : 1);
            }
            return dp[len - 1][2];
        }
    }
}
