package cn.edu.nju.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/10/5
 */
public class LeetCode18 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fourSum(new int[]{-7, -5, 0, 7, 1, 1, -10, -2, 7, 7, -2, -6, 0, -10, -5, 7, -8, 5}, 28));
        System.out.println(solution.fourSum(new int[]{0, 0, 0, 0}, 0));
        System.out.println(solution.fourSum(new int[]{1, -2, -5, -4, -3, 3, 3, 5}, -11));
    }

    /**
     * 与三数之和解法相同，排序+双指针
     */
    static class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums == null || nums.length < 4) return res;
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 3; i++) {
                while (i > 0 && i < nums.length - 3 && nums[i] == nums[i - 1]) i++;
                if (i == nums.length - 3) break;
                for (int j = i + 1; j < nums.length - 2; j++) {
                    while (j > i + 1 && j < nums.length - 2 && nums[j] == nums[j - 1]) j++;
                    if (j == nums.length - 2) break;
                    int left = j + 1;
                    int right = nums.length - 1;
                    while (left < right) {
                        int sum = nums[i] + nums[j] + nums[left] + nums[right];
                        if (sum == target) {
                            res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                            while (left < nums.length - 1 && nums[left] == nums[left + 1]) left++;
                            while (right > 0 && nums[right] == nums[right - 1]) right--;
                            left++;
                            right--;
                        } else if (sum > target) {
                            right--;
                        } else {
                            left++;
                        }
                    }
                }
            }
            return res;
        }
    }
}
