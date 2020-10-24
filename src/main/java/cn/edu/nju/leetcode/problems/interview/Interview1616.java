package cn.edu.nju.leetcode.problems.interview;

import java.util.Arrays;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/10/24
 */
public class Interview1616 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.subSort(new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19})));
    }

    /**
     * 假设数组排好序，则从左向右应该保持递增，从右向左应该保持递减
     */
    static class Solution {
        public int[] subSort(int[] array) {
            if (array == null || array.length == 0) return new int[]{-1, -1};
            // 记录处于最右边的逆序对的位置
            int right = -1;
            // 从左向右最大值
            int max = array[0];
            // 记录处于最左边的逆序对的位置
            int left = -1;
            // 从右向左最小值
            int min = array[array.length - 1];
            // 一次循环，双向遍历
            for (int i = 1; i < array.length; i++) {
                // 从前向后，当前位置与左边的 max 构成逆序对，更新最右位置
                if (array[i] < max) {
                    right = i;
                } else {
                    max = array[i];
                }
                // 从后向前，当前位置与右边的 min 构成逆序对，更新最左位置
                if (array[array.length - 1 - i] > min) {
                    left = array.length - 1 - i;
                } else {
                    min = array[array.length - 1 - i];
                }
            }
            return new int[]{left, right};
        }
    }
}
