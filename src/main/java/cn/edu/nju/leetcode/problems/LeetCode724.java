package cn.edu.nju.leetcode.problems;

import java.util.stream.IntStream;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/10/3
 */
public class LeetCode724 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.pivotIndex(new int[]{-1, -1, -1, -1, -1, 0}));
        System.out.println(solution.pivotIndex(new int[]{-1, -1, -1, -1, -1, -1}));
    }

    /**
     * 使用前缀和
     */
    static class Solution {
        public int pivotIndex(int[] nums) {
            if (nums == null || nums.length == 0) return -1;
            int sum = IntStream.of(nums).sum();
            int pre = 0;
            for (int i = 0; i < nums.length; i++) {
                if (pre == sum - pre - nums[i]) return i;
                pre += nums[i];
            }
            return -1;
        }
    }
}
