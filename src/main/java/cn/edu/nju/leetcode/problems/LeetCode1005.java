package cn.edu.nju.leetcode.problems;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/10/13
 */
public class LeetCode1005 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestSumAfterKNegations(new int[]{4, 2, 1}, 1));
        System.out.println(solution.largestSumAfterKNegations(new int[]{2, -3, -1, 5, -4}, 2));
        System.out.println(solution.largestSumAfterKNegations(new int[]{5, 6, 9, -3, 3}, 2));
    }

    static class Solution {
        public int largestSumAfterKNegations(int[] A, int K) {
            if (A == null) return 0;
            Arrays.sort(A);
            int sum = IntStream.of(A).sum();
            int cnt = 0;
            if (A[0] < 0) {
                for (int i = 0; i < A.length && cnt < K; i++) {
                    if (A[i] == 0) break;
                    if (A[i] < 0) {
                        sum += 2 * Math.abs(A[i]);
                        cnt++;
                    } else {
                        if ((K - cnt) % 2 == 1) sum = Math.max(sum - 2 * A[i], sum + 2 * A[i - 1]);
                        break;
                    }
                }
            } else {
                sum = K % 2 == 0 ? sum : sum - 2 * A[0];
            }
            return sum;
        }
    }
}
