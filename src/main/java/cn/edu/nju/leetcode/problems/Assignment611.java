package cn.edu.nju.leetcode.problems;

import java.util.Arrays;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/9/26
 */
public class Assignment611 {
    static class Solution {
        public int triangleNumber(int[] nums) {
            Arrays.sort(nums);
            int cnt = 0;
            for (int i = 0; i < nums.length - 2; i++) {
                int j = i + 1, k = i + 2;
                while (k < nums.length) {
                    if (nums[i] + nums[j] > nums[k]) {
                        cnt += k - j;
                        k++;
                    } else {
                        if (j < k - 1) {
                            j++;
                        } else {
                            j++;
                            k++;
                        }
                    }
                }
            }
            return cnt;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.triangleNumber(new int[]{2, 2, 3, 3, 4, 4, 5}));
    }
}
