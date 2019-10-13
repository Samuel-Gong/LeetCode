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
public class Assignment4 {

    /**
     * 因为是找两个有序数组的中位数，第一思路就是运用归并排序中的 merge
     * 实现的时间复杂度为 O((m+n)/2)，并不符合题目要求，但是可以通过所有测试用例
     */
    static class Solution1 {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int p1 = 0;
            int p2 = 0;
            int len1 = nums1.length;
            int len2 = nums2.length;
            int[] all = new int[len1 + len2];
            int k = 0;
            while (p1 < len1 && p2 < len2) {
                if (nums1[p1] <= nums2[p2]) {
                    all[k++] = nums1[p1++];
                } else {
                    all[k++] = nums2[p2++];
                }
            }

            while (p1 < len1) {
                all[k++] = nums1[p1++];
            }
            while (p2 < len2) {
                all[k++] = nums2[p2++];
            }

            int len = all.length;
            if (len % 2 != 0) {
                return all[len / 2];
            } else {
                return (all[len / 2] + all[len / 2 - 1]) / 2.0;
            }
        }
    }

    /**
     * 不将两个数组排序，找到中位数即停止
     */
    static class Solution2 {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int p1 = 0;
            int p2 = 0;
            int len1 = nums1.length;
            int len2 = nums2.length;
            int len = len1 + len2;
            int left = -1;
            int right = -1;
            for (int i = 0; i <= len / 2; i++) {
                left = right;
                // 两个数组都未耗尽
                if (p1 != len1 && p2 != len2) {
                    if (nums1[p1] < nums2[p2]) {
                        right = nums1[p1++];
                    } else {
                        right = nums2[p2++];
                    }
                } else if (p1 == len1) { // 左数组耗尽
                    right = nums2[p2++];
                } else { // 右数组耗尽
                    right = nums1[p1++];
                }
            }

            if ((len & 1) != 0) {
                return right;
            } else {
                return (left + right) / 2.0;
            }
        }
    }

    static class Solution3 {

        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int len1 = nums1.length;
            int len2 = nums2.length;
            int len = len1 + len2;
            int k = (len + 1) / 2;
            int halfK = k / 2;
            int p1 = 0;
            int p2 = 0;
            while (halfK > 0 && p1 < len1 && p2 < len2) {
                // 临时调整指向两数组的指针
                int tp1 = halfK + p1 >= len1 ? len1 - 1 : p1 + halfK - 1;
                int tp2 = halfK + p2 >= len2 ? len2 - 1 : p2 + halfK - 1;

                int dis;
                if (nums1[tp1] <= nums2[tp2]) {
                    dis = tp1 - p1 + 1;
                    p1 = tp1 + 1;
                } else {
                    dis = tp2 - p2 + 1;
                    p2 = tp2 + 1;
                }

                k = halfK < dis ? k - halfK : k - dis;
                halfK = k / 2;
            }

            int left = 0;
            if (p1 >= len1 || p2 >= len2) {
                if (p1 >= len1) {
                    p2 = p2 + k - 1;
                    left = nums2[p2++];
                } else {
                    p1 = p1 + k - 1;
                    left = nums1[p1++];
                }
            } else if (nums1[p1] <= nums2[p2]) {
                left = nums1[p1++];
            } else {
                left = nums2[p2++];
            }

            if ((len & 1) != 0) {
                return left;
            } else {
                int right = 0;
                if (p1 >= len1 || p2 >= len2) {
                    if (p1 >= len1) {
                        right = nums2[p2];
                    }
                    if (p2 >= len2) {
                        right = nums1[p1];
                    }
                } else if (nums1[p1] <= nums2[p2]) {
                    right = nums1[p1];
                } else {
                    right = nums2[p2];
                }
                return (left + right) / 2.0;
            }
        }

    }

    static class Solution4 {

        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int n = nums1.length;
            int m = nums2.length;
            int left = (n + m + 1) / 2;
            int right = (n + m + 2) / 2;
            //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
            return (getKth(nums1, 0, nums2, 0, left) + getKth(nums1, 0, nums2, 0, right)) * 0.5;
        }

        private int getKth(int[] nums1, int p1, int[] nums2, int p2, int k) {
            int len1 = nums1.length - p1;
            int len2 = nums2.length - p2;
            //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
            if (len1 > len2) {
                return getKth(nums2, p2, nums1, p1, k);
            }
            if (len1 == 0) {
                return nums2[p2 + k - 1];
            }

            if (k == 1) {
                return Math.min(nums1[p1], nums2[p2]);
            }

            int i = p1 + Math.min(len1, k / 2) - 1;
            int j = p2 + Math.min(len2, k / 2) - 1;

            if (nums1[i] > nums2[j]) {
                return getKth(nums1, p1, nums2, j + 1, k - (j - p2 + 1));
            } else {
                return getKth(nums1, i + 1, nums2, p2, k - (i - p1 + 1));
            }
        }

    }

    public static void main(String[] args) {
//        Solution1 solution1 = new Solution1();
//        System.out.println(solution1.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
//        System.out.println(solution1.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));

//        Solution2 solution2 = new Solution2();
//        System.out.println(solution2.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
//        System.out.println(solution2.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));

        Solution4 solution4 = new Solution4();
        System.out.println(solution4.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        System.out.println(solution4.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(solution4.findMedianSortedArrays(new int[]{}, new int[]{1}));
        System.out.println(solution4.findMedianSortedArrays(new int[]{}, new int[]{2, 3}));
        System.out.println(solution4.findMedianSortedArrays(new int[]{}, new int[]{1, 2, 3, 4}));
        System.out.println(solution4.findMedianSortedArrays(new int[]{1}, new int[]{2, 3, 4, 5, 6, 7}));
    }

}
