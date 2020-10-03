package cn.edu.nju.leetcode.problems;

import java.util.Arrays;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/10/3
 */
public class LeetCode34 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
    }

    static class Solution {
        public int[] searchRange(int[] nums, int target) {
            int left = 0;
            int right = nums.length;
            // 左闭右开，寻找左边界
            while (left < right) {
                int mid = left + (right - left) / 2;
                // 相等的时候收缩右边界
                if (nums[mid] == target) right = mid;
                else if (nums[mid] < target) left = mid + 1;
                else if (nums[mid] > target) right = mid;
            }
            int leftBorder;
            // 边界条件判断
            // 1. target 大于 nums 中的所有数字时，左边界会越界
            // 2. target 小于 nums 的最小值时，右边界会一直向 0 收缩，直到等于 0，此时 nums[0] != target
            // 3. target 处于 nums 的范围内时，nums[left] 是小于 target 的最大的数
            if (left == nums.length || nums[left] != target) leftBorder = -1;
            else leftBorder = left;
            if (leftBorder == -1) return new int[]{-1, -1};

            left = 0;
            right = nums.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                // 相等的时候收缩左边界
                if (nums[mid] == target) left = mid + 1;
                else if (nums[mid] < target) left = mid + 1;
                else if (nums[mid] > target) right = mid;
            }
            // 这里不需要边界条件判断，因为已经确认 target 在数组中
            int rightBorder = left - 1;
            return new int[]{leftBorder, rightBorder};
        }
    }
}
