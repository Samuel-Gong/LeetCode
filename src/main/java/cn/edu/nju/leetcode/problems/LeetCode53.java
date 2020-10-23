package cn.edu.nju.leetcode.problems;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/10/23
 */
public class LeetCode53 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution1 solution1 = new Solution1();
        System.out.println(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(solution1.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    /**
     * 动态规划
     * 注意：dp[i] 的定义为以 nums[i] 结尾的最大子数组和
     * https://labuladong.gitbook.io/algo/dong-tai-gui-hua-xi-lie/zui-da-zi-shu-zu
     */
    static class Solution {
        public int maxSubArray(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }

    /**
     * 前一种方法基础上的状态压缩
     */
    static class Solution1 {
        public int maxSubArray(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int max = nums[0];
            int pre = nums[0];
            for (int i = 1; i < nums.length; i++) {
                pre = Math.max(pre + nums[i], nums[i]);
                max = Math.max(max, pre);
            }
            return max;
        }
    }
}
