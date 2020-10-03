package cn.edu.nju.leetcode.problems;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/10/3
 */
public class LeetCode35 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 0));
        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 7));
    }

    /**
     * 寻找插入位置，可以按照闭区间的二分搜索来做
     * 可知退出循环时，left = right + 1，nums[right] < target < nums[left]
     * 故插入位置为 left
     */
    static class Solution {
        public int searchInsert(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) return mid;
                else if (nums[mid] < target) left = mid + 1;
                else right = mid - 1;
            }
            return left;
        }
    }
}
