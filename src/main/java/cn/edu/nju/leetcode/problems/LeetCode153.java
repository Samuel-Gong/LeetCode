package cn.edu.nju.leetcode.problems;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/10/15
 */
public class LeetCode153 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println(solution.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(solution.findMin(new int[]{2, 1}));
    }

    /**
     * 使用二分法的变式
     * 注意这里找最小值，偏向左侧找，中值是与右值比较的，因为情况简单
     * 若与左值比较，会存在 中值 = 左值的情况，则需要另行讨论
     */
    static class Solution {
        public int findMin(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int left = 0;
            int right = nums.length - 1;
            int mid;
            while (left < right) {
                // 若 [l..h] 递增，则 nums[l] 为最小值
                if (nums[right] > nums[left]) return nums[left];
                mid = left + (right - left) / 2;
                if (nums[mid] > nums[right]) { // 中值 > 右值，最小值在右半部分
                    left = mid + 1;
                } else if (nums[mid] < nums[right]) { // 中值 < 右值，最小值在左半部分，中值也可能是最小值
                    right = mid;
                }
            }
            return nums[left];
        }
    }
}
