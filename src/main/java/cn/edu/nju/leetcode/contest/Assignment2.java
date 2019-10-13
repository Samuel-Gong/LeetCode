package cn.edu.nju.leetcode.contest;

import java.util.Arrays;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/9/24
 */
public class Assignment2 {

    static class Solution {
        public int[] fraction(int[] cont) {
            int a = 1;
            int b = cont[cont.length - 1];
            if (cont.length == 1) {
                return new int[]{b, a};
            }
            for (int i = cont.length - 2; i > 0; i--) {
                int tmp = b;
                b = cont[i] * b + a;
                a = tmp;
            }
            a = cont[0] * b + a;
            int gcd = gcd(Math.min(a, b), Math.max(a, b));
            a = a / gcd;
            b = b / gcd;
            return new int[]{a, b};
        }

        private int gcd(int a, int b) {
            if (a == 0) {
                return b;
            }
            return gcd(b % a, a);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.fraction(new int[]{3, 2, 0, 2})));
    }
}
