package cn.edu.nju.leetcode.contest;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/9/22
 */
public class Assignment5198 {
    static class Solution {
        public int nthUglyNumber(int n, int a, int b, int c) {
            int low = 1, high = Integer.MAX_VALUE, mid;
            while (low < high) {
                mid = low + (high - low) / 2;
                if (count(a, b, c, mid) < n) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return high;
        }

        private long gcd(long a, long b) {
            if (a == 0) {
                return b;
            }
            return gcd(b % a, a);
        }

        private long lcm(long a, long b) {
            return a * b / gcd(a, b);
        }

        private int count(int a, int b, int c, int num) {
            return (int) ((num / a) + (num / b) + (num / c)
                    - (num / lcm(a, b))
                    - (num / lcm(b, c))
                    - (num / lcm(a, c))
                    + (num / lcm(a, lcm(b, c))));
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nthUglyNumber(3, 2, 3, 5));
    }
}
