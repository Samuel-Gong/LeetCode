package cn.edu.nju.leetcode.problems;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/9/30
 */
public class LeetCode33 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    }

    static class Solution {
        public int search(int[] nums, int target) {
            int pivot = searchPivot(nums, 0, nums.length - 1);
            int left = 0;
            int right = nums.length - 1;
            if (pivot == -1) {
            } else if (nums[0] <= target && target <= nums[pivot - 1]) {
                right = pivot - 1;
            } else {
                left = pivot;
            }
            while (left <= right) {
                int mid = (right - left) / 2 + left;
                if (target == nums[mid]) return mid;
                else if (nums[mid] > target) right = mid - 1;
                else left = mid + 1;
            }
            return -1;
        }

        public int searchPivot(int[] nums, int left, int right) {
            if (left == right) return -1;
            if (right - left == 1) {
                if (nums[left] > nums[right]) return right;
                return -1;
            }
            if (nums[right] >= nums[left]) return -1;
            int mid = (right - left) / 2 + left;
            int pivotL = searchPivot(nums, left, mid);
            int pivotR = searchPivot(nums, mid, right);
            return Math.max(pivotL, pivotR);
        }
    }
}
