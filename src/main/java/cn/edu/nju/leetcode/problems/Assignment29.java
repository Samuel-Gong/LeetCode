package cn.edu.nju.leetcode.problems;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * <p>
 * 示例 1:
 * <p>
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 说明:
 * <p>
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。本题中，如果除法结果溢出，则返回 2^31 − 1。
 *
 * <p>
 *
 * @author Shenmiu
 * @date 2019-07-27
 */
public class Assignment29 {

    static class Solution {
        public int divide(int dividend, int divisor) {

            if (divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1) {
                return Integer.MAX_VALUE;
            } else {
                boolean neg = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
                dividend = dividend < 0 ? dividend : -dividend;
                divisor = divisor < 0 ? divisor : -divisor;
                int res = divid(dividend, divisor);
                return neg ? -res : res;
            }
        }

        private int divid(int dividend, int divisor) {
            if (dividend > divisor) {
                return 0;
            }

            int res = 1;
            int oldDividend = dividend;
            int oldDivisor = divisor;

            dividend -= divisor;
            while (divisor >= dividend) {
                dividend -= divisor;
                res += res;
                divisor += divisor;
            }

            return res + divid(oldDividend - divisor, oldDivisor);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.divide(-1, 1));
        System.out.println(solution.divide(-2147483648, -1));
        System.out.println(solution.divide(-2147483648, 2));
        System.out.println(solution.divide(10, 3));
    }

}
