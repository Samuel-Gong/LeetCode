package cn.edu.nju.leetcode.problems;

import java.util.Arrays;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/10/18
 */
public class LeetCode1405 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestDiverseString(1, 1, 7));
        System.out.println(solution.longestDiverseString(2, 2, 1));
    }

    /**
     * 贪心策略，每次选择剩余字符最多的
     */
    static class Solution {
        public String longestDiverseString(int a, int b, int c) {
            int[][] arr = new int[][]{{0, a}, {1, b}, {2, c}};
            StringBuilder sb = new StringBuilder();
            char last = '0';
            int num = 0;
            while (true) {
                Arrays.sort(arr, (n1, n2) -> n2[1] - n1[1]);
                if (arr[0][1] == 0) break;
                char maxChar = (char) ('a' + arr[0][0]);
                // 判断是否可以选字符最多的，可以就选最多的
                if (last != maxChar || num < 2) {
                    num = last == maxChar ? num + 1 : 1;
                    last = maxChar;
                    sb.append(maxChar);
                    arr[0][1]--;
                } else {
                    if (arr[1][1] == 0) break;
                    last = (char) ('a' + arr[1][0]);
                    num = 1;
                    sb.append(last);
                    arr[1][1]--;
                }
            }
            return sb.toString();
        }
    }
}
