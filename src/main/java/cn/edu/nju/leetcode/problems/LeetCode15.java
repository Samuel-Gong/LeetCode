package cn.edu.nju.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 *
 * <p>
 *
 * @author Shenmiu
 * @date 2020/7/25
 */
public class LeetCode15 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    /**
     * 排序 + 双指针
     * 时间复杂度：O(n^2)
     */
    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums == null || nums.length < 3) return res;
            Arrays.sort(nums);
            // 选定第 i 位置的数作为第一个数
            // 使用双指针 L, R 分别指向 i 的右边区间的两个数
            for (int i = 0; i < nums.length - 2; i++) {
                // 去重，去掉值相同的 i
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                int L = i + 1;
                int R = nums.length - 1;
                if (nums[i] + nums[L] > 0) break;
                while (L < R) {
                    int sum = nums[i] + nums[L] + nums[R];
                    if (sum == 0) {
                        res.add(Arrays.asList(nums[i], nums[L], nums[R]));
                        // 去重，sum 为 0 的时候，不应该重复选择相同值的 L 或 R
                        while (L < R && nums[L] == nums[L + 1]) L++;
                        while (L < R && nums[R] == nums[R - 1]) R--;
                        L++;
                        R--;
                    } else if (sum < 0) {
                        L++;
                    } else {
                        R--;
                    }
                }
            }
            return res;
        }
    }
}
