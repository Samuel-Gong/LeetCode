package cn.edu.nju.leetcode.problems;

import java.util.Arrays;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/10/3
 */
public class Assignment377 {
    static class Solution {
        public int combinationSum4(int[] nums, int target) {
            if (target == 0) {
                return 1;
            }
            int res = 0;
            for (int num : nums) {
                if (target >= num) {
                    res += combinationSum4(nums, target - num);
                }
            }
            return res;
        }

    }

    static class Solution2 {
        int res = 0;

        public int combinationSum4(int[] nums, int target) {
            Arrays.sort(nums);
            if (target <= 3) {
                count(nums, target);
                return res;
            }
            int[] dp = new int[target + 1];

            dp[0] = 0;
            res = 0;
            count(nums, 1);
            dp[1] = res;
            res = 0;
            count(nums, 2);
            dp[2] = res;
            res = 0;
            count(nums, 3);
            dp[3] = res;
            int index = 0;
            for (int i = 4; i < target + 1; i++) {
                while (index < nums.length && nums[index] < i) {
                    index++;
                }
                if (index < nums.length && nums[index] == i) {
                    dp[i] = 1;
                }
                for (int j = index - 1; j >= 0; j--) {
                    dp[i] += dp[i - nums[j]];
                }
            }

            return dp[target];
        }

        private void count(int[] nums, int target) {
            int diff;
            for (int num : nums) {
                diff = target - num;
                if (diff == 0) {
                    res++;
                } else if (diff < 0) {
                    return;
                } else {
                    count(nums, diff);
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combinationSum4(new int[]{1, 2, 3}, 4));
        System.out.println(solution.combinationSum4(new int[]{3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25}
                , 35));

        Solution2 solution2 = new Solution2();
        System.out.println(solution2.combinationSum4(new int[]{1, 2, 3}, 4));
        System.out.println(solution2.combinationSum4(new int[]{3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25}
                , 35));
    }
}
