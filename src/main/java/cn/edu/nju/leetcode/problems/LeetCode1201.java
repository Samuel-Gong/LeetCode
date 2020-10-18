package cn.edu.nju.leetcode.problems;

/**
 * 请你帮忙设计一个程序，用来找出第 n 个丑数。
 * 丑数是可以被 a 或 b 或 c 整除的正整数。
 * <p>
 * 提示：
 * <p>
 * 1 <= n, a, b, c <= 10^9
 * 1 <= a * b * c <= 10^18
 * 本题结果在 [1, 2 * 10^9] 的范围内
 * <p>
 *
 * @author Shenmiu
 * @date 2020/10/18
 */
public class LeetCode1201 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nthUglyNumber(3, 2, 3, 5));
        System.out.println(solution.nthUglyNumber(5, 2, 11, 13));
        System.out.println(solution.nthUglyNumber(1000000000, 2, 217983653, 336916467));
    }

    /**
     * 由题目条件限制看到，n 的范围很大，线性搜索很可能超时，故想到使用二分法去猜测一个丑数，看这个丑数是否满足题意
     * https://leetcode-cn.com/problems/ugly-number-iii/solution/er-fen-fa-si-lu-pou-xi-by-alfeim/
     */
    static class Solution {
        public int nthUglyNumber(int n, int a, int b, int c) {
            long low = 0;
            long high = Integer.MAX_VALUE;
            long mid;
            long lcm_a_b = lcm(a, b);
            long lcm_a_c = lcm(a, c);
            long lcm_b_c = lcm(b, c);
            long lcm_a_b_c = lcm(lcm_a_b, c);
            while (low <= high) {
                mid = low + (high - low) / 2;
                long uglyCount = mid / a + mid / b + mid / c - mid / lcm_a_b - mid / lcm_a_c - mid / lcm_b_c + mid / lcm_a_b_c;
                if (uglyCount == n) high = high - 1;
                else if (uglyCount > n) high = mid - 1;
                else low = mid + 1;
            }
            return (int) low;
        }

        private long lcm(long a, long b) {
            long originA = a;
            long originB = b;
            long tmp;
            while (b > 0) {
                tmp = a % b;
                a = b;
                b = tmp;
            }
            return originA / a * originB;
        }
    }
}
