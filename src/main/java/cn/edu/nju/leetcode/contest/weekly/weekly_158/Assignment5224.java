package cn.edu.nju.leetcode.contest.weekly.weekly_158;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/10/13
 */
public class Assignment5224 {
    static class Solution {
        public int dieSimulator(int n, int[] rollMax) {
            if (n == 0) {
                return 0;
            }
            long res = 0;
            res += recursive(n, rollMax, 1, 1, 1);
            res += recursive(n, rollMax, 1, 2, 1);
            res += recursive(n, rollMax, 1, 3, 1);
            res += recursive(n, rollMax, 1, 4, 1);
            res += recursive(n, rollMax, 1, 5, 1);
            res += recursive(n, rollMax, 1, 6, 1);
            return (int) (res % (((int) Math.pow(10, 9)) + 7));
        }

        private long recursive(int n, int[] rollMax, int cur, int lastNum, int num) {
            if (cur == n) {
                return 1;
            }
            long count = 0;
            for (int i = 1; i <= 6; i++) {
                if (i != lastNum) {
                    count += recursive(n, rollMax, cur + 1, i, 1);
                } else {
                    if (num < rollMax[lastNum - 1]) {
                        count += recursive(n, rollMax, cur + 1, i, num + 1);
                    }
                }
            }
            return count;
        }
    }

    static class Solution2 {
        public int dieSimulator(int n, int[] rollMax) {
            if (n == 0) {
                return 0;
            }
            long[] dp = new long[n + 1];
            dp[0] = 1;
            long res = 1;
            for (int i = 1; i <= n; i++) {
                res *= 6;
                for (int j = 0; j < rollMax.length; j++) {
                    if (i > rollMax[j]) {
                        if (i - rollMax[j] - 2 < 0) {
                            res -= 1;
                        } else {
                            if (i - rollMax[j] - 3 < 0) {
                                res -= dp[i - rollMax[j] - 2] * 5;
                            } else {
                                res -= dp[i - rollMax[j] - 2] * 5 * dp[i - rollMax[j] - 3];
                            }
                        }
                    }
                }
                dp[i] = res;
            }
            return (int) (res % (((int) Math.pow(10, 9)) + 7));
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.dieSimulator(2, new int[]{1, 1, 2, 2, 2, 3}));
//        System.out.println(solution.dieSimulator(2, new int[]{1, 1, 1, 1, 1, 1}));
//        System.out.println(solution.dieSimulator(2, new int[]{1, 1, 1, 2, 2, 3}));
//        System.out.println(solution.dieSimulator(4, new int[]{2, 1, 1, 3, 3, 2}));
//        System.out.println(solution.dieSimulator(3, new int[]{2, 1, 1, 3, 3, 2}));

        Solution2 solution2 = new Solution2();
        System.out.println(solution2.dieSimulator(2, new int[]{1, 1, 2, 2, 2, 3}));
        System.out.println(solution2.dieSimulator(2, new int[]{1, 1, 1, 1, 1, 1}));
        System.out.println(solution2.dieSimulator(3, new int[]{1, 1, 1, 2, 2, 3}));
        System.out.println(solution2.dieSimulator(4, new int[]{2, 1, 1, 3, 3, 2}));
        System.out.println(solution2.dieSimulator(3, new int[]{2, 1, 1, 3, 3, 2}));
    }
}
