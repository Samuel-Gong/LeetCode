package cn.edu.nju.leetcode.problems;

import java.util.Arrays;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/9/29
 */
public class LeetCode16 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }

    static class Solution {
        public int threeSumClosest(int[] nums, int target) {
            int diff = Integer.MAX_VALUE;
            int res = 0;
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; i++) {
                int L = i + 1;
                int R = nums.length - 1;
                while (L < R) {
                    int sum = nums[i] + nums[L] + nums[R];
                    if (Math.abs(sum - target) <= diff) {
                        res = sum;
                        diff = Math.abs(sum - target);
                    }
                    if (sum - target > 0) R--;
                    if (sum - target < 0) L++;
                    if (sum - target == 0) return sum;
                }
            }
            return res;
        }
    }
}
