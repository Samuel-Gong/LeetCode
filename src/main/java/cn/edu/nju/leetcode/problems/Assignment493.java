package cn.edu.nju.leetcode.problems;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/9/25
 */
public class Assignment493 {
    static class Solution {
        int count = 0;
        int[] aux;
        long[] aux2;

        public int reversePairs(int[] nums) {
            if (nums.length == 0) {
                return count;
            }
            aux = new int[nums.length];
            aux2 = new long[nums.length];
            sort(nums, 0, nums.length - 1);
            return count;
        }

        private void sort(int[] nums, int lo, int hi) {
            if (lo == hi) {
                return;
            }
            int mid = lo + (hi - lo) / 2;
            sort(nums, lo, mid);
            sort(nums, mid + 1, hi);
            merge(nums, lo, mid, hi);
        }

        private void merge(int[] nums, int lo, int mid, int hi) {
            System.arraycopy(nums, lo, aux, lo, hi - lo + 1);
            for (int m = mid + 1; m <= hi; m++) {
                aux2[m] = aux[m] * 2L;
            }
            int i = lo, j = mid + 1;
            for (int k = lo; k <= hi; k++) {
                if (i > mid) {
                    j++;
                } else if (j > hi) {
                    i++;
                } else if (aux2[j] < aux[i]) {
                    count += mid - i + 1;
                    j++;
                } else {
                    i++;
                }
            }
            i = lo;
            j = mid + 1;
            for (int k = lo; k <= hi; k++) {
                if (i > mid) {
                    nums[k] = aux[j++];
                } else if (j > hi) {
                    nums[k] = aux[i++];
                } else if (aux[j] < aux[i]) {
                    nums[k] = aux[j++];
                } else {
                    nums[k] = aux[i++];
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reversePairs(new int[]{2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647}));
    }
}
