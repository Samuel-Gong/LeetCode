package cn.edu.nju.leetcode.problems;

import java.util.Arrays;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/9/30
 */
public class LeetCode322 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(solution.coinChange(new int[]{474, 83, 404, 3}, 264));
    }

    /**
     * 使用 dp 求解
     * dp[i] 表示 amount 为 i 时，需要的最少硬币
     * dp[i] 可以通过 dp[i - coins[j]] 来推导
     */
    static class Solution {
        public int coinChange(int[] coins, int amount) {
            if (coins == null || coins.length == 0) return -1;
            int[] dp = new int[amount + 1];
            // 全部初始化为
            Arrays.fill(dp, amount + 1);
            dp[0] = 0;
            Arrays.sort(coins);
            for (int i = 0; i < dp.length; i++) {
                for (int coin : coins) {
                    if (i - coin >= 0) dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    else break;
                }
            }
            return dp[dp.length - 1] == amount + 1 ? -1 : dp[dp.length - 1];
        }
    }

}
