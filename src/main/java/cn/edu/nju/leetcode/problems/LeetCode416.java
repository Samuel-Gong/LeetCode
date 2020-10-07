package cn.edu.nju.leetcode.problems;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/10/7
 */
public class LeetCode416 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(solution.canPartition(new int[]{1, 2, 3, 5}));
    }

    /**
     * 子集背包问题
     * 给一个可装载重量为 sum / 2 的背包和 N 个物品，每个物品的重量为 nums[i]。
     * 现在让你装物品，是否存在一种装法，能够恰好将背包装满？
     * <p>
     * 恰好装满则表示可以等分
     */
    static class Solution {
        public boolean canPartition(int[] nums) {
            if (nums == null || nums.length == 0) return false;
            int sum = IntStream.of(nums).sum();
            if (sum % 2 == 1) return false;
            boolean[][] dp = new boolean[nums.length + 1][sum / 2 + 1];
            // base case
            // dp[0][..] 表示 0 个物品，则肯定没法将背包装满，全部设为 false
            Arrays.fill(dp[0], false);
            // dp[..][0] 表示容量为 0，则背包就是满的
            for (int i = 0; i < nums.length + 1; i++) {
                dp[i][0] = true;
            }
            for (int i = 1; i < nums.length + 1; i++) {
                for (int j = 0; j < sum / 2 + 1; j++) {
                    // 容量不够装入第 i 个物品，则状态由相同容量下，前 i-1 个物品的状态决定
                    if (j - nums[i - 1] < 0) dp[i][j] = dp[i - 1][j];
                        // 容量够装入第 i 个物品，需要进行选择，装入或不装入
                    else dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
            System.out.println(Arrays.deepToString(dp));
            return dp[nums.length][sum / 2];
        }
    }
}
