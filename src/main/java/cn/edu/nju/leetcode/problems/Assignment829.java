package cn.edu.nju.leetcode.problems;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/10/8
 */
public class Assignment829 {
    static class Solution {
        public int consecutiveNumbersSum(int N) {
            int count = 0;
            int limit = (int) Math.ceil(Math.sqrt(2 * N + 2)) - 1;
            for (int i = 1; i <= limit; i++) {
                if ((2 * N - i * (i - 1)) % (2 * i) == 0) {
                    count++;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.consecutiveNumbersSum(15));
    }
}
