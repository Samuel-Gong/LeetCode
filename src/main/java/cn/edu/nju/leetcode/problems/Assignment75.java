package cn.edu.nju.leetcode.problems;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/9/25
 */
public class Assignment75 {
    class Solution {
        public void sortColors(int[] nums) {
            sort(nums, 0, nums.length - 1);
        }

        private void sort(int[] nums, int lo, int hi) {
            if (hi <= lo) {
                return;
            }
            int lt = lo, i = lo + 1, gt = hi;
            int v = nums[lo];
            while (i <= gt) {
                if (nums[i] < v) {
                    swap(nums, lt++, i++);
                } else if (nums[i] > v) {
                    swap(nums, i, gt--);
                } else {
                    i++;
                }
            }
            sort(nums, lo, lt - 1);
            sort(nums, gt + 1, hi);
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
