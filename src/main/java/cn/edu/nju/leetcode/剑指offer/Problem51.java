package cn.edu.nju.leetcode.剑指offer;

/**
 * 逆序对
 * <p>
 *
 * @author Shenmiu
 * @date 2020/10/10
 */
public class Problem51 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reversePairs(new int[]{7, 5, 6, 4}));
        System.out.println(solution.reversePairs(new int[]{1, 3, 2, 3, 1}));
    }

    static class Solution {
        int reversePairs = 0;
        int[] auxiliary;

        public int reversePairs(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            auxiliary = new int[nums.length];
            sort(nums, 0, nums.length - 1);
            return reversePairs;
        }

        private void sort(int[] nums, int low, int high) {
            if (low == high) return;
            int mid = low + (high - low) / 2;
            sort(nums, low, mid);
            sort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }

        private void merge(int[] nums, int low, int mid, int high) {
            System.arraycopy(nums, low, auxiliary, low, high + 1 - low);
            int p1 = low;
            int p2 = mid + 1;
            int index = low;
            while (p1 <= mid && p2 <= high) {
                int left = auxiliary[p1];
                int right = auxiliary[p2];
                if (left <= right) {
                    nums[index] = left;
                    p1++;
                } else {
                    // 右指针移动的时候计算对逆序对的贡献
                    // 可知贡献度为 p1...mid 的长度
                    reversePairs += (mid - p1 + 1);
                    nums[index] = right;
                    p2++;
                }
                index++;
            }
            while (p1 <= mid) {
                nums[index++] = auxiliary[p1++];
            }
            while (p2 <= high) {
                nums[index++] = auxiliary[p2++];
            }
        }
    }
}
