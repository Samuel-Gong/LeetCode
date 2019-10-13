package cn.edu.nju.leetcode.problems;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/10/7
 */
public class Assignment410 {
    static class Solution {
        public int splitArray(int[] nums, int m) {
            long left = 0, right = 0;
            for (int i : nums) {
                left = Math.max(i, left);
                right += i;
            }

            long max = right;
            long tmp;
            while (left < right) {
                long mid = left + (right - left) / 2;
                long cur = 0;
                int need = 1;
                tmp = 0;
                for (int i : nums) {
                    if (cur + i > mid) {
                        need++;
                        tmp = Math.max(tmp, cur);
                        cur = 0;
                    }
                    if (need > m) {
                        break;
                    }
                    cur += i;
                }
                if (need <= m) {
                    tmp = Math.max(tmp, cur);
                    max = Math.min(max, tmp);
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            return (int) max;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.splitArray(new int[]{7, 2, 5, 10, 8}, 2));
        System.out.println(solution.splitArray(new int[]{1, 2147483647}, 2));
        System.out.println(solution.splitArray(new int[]{2, 3, 1, 1, 1, 1, 1}, 5));
    }
}
