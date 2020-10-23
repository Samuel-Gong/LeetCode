package cn.edu.nju.leetcode.problems;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * @author Shenmiu
 * @date 2019-07-23
 */
public class LeetCode4 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        System.out.println(solution.findMedianSortedArrays(new int[]{0, 0}, new int[]{0, 0}));
        System.out.println(solution.findMedianSortedArrays(new int[]{}, new int[]{1}));
        System.out.println(solution.findMedianSortedArrays(new int[]{2}, new int[]{}));
    }

    /**
     * 二分法
     */
    static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int len1 = nums1.length;
            int len2 = nums2.length;
            // 计算中位数的位置
            // 对奇数长度来说，重复计算中位数两次
            // 对偶数长度来说，分别计算左中位数以及右中位数
            int left = (len1 + len2 + 1) / 2;
            int right = (len1 + len2 + 2) / 2;
            return (getKth(nums1, 0, nums2, 0, left) + getKth(nums1, 0, nums2, 0, right)) / 2.0;
        }

        private int getKth(int[] nums1, int index1, int[] nums2, int index2, int k) {
            if (index1 == nums1.length) return nums2[index2 + k - 1];
            if (index2 == nums2.length) return nums1[index1 + k - 1];
            if (k == 1) return Math.min(nums1[index1], nums2[index2]);

            // 计算下一个有效的 index
            // index 不能超出数组长度
            // index 每次增加 k/2（采用二分的策略，每次将小的 k/2 部分舍弃）
            int i = Math.min(nums1.length - 1, index1 + k / 2 - 1);
            int j = Math.min(nums2.length - 1, index2 + k / 2 - 1);
            // 注意下一次递归 k 的计算，不能直接减去 k/2，要计算减去的有效长度
            if (nums1[i] < nums2[j]) {
                return getKth(nums1, i + 1, nums2, index2, k - (i - index1 + 1));
            } else {
                return getKth(nums1, index1, nums2, j + 1, k - (j - index2 + 1));
            }
        }
    }
}
