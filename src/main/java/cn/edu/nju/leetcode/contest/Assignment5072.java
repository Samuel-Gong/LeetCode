package cn.edu.nju.leetcode.contest;

import java.util.Arrays;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/9/21
 */
public class Assignment5072 {
    class Solution {
        public int maxNumberOfApples(int[] arr) {
            Arrays.sort(arr);
            int count = 0;
            int sum = 5000;
            for (int a : arr) {
                sum -= a;
                if (sum < 0) {
                    break;
                }
                count++;
            }
            return count;
        }
    }
}
