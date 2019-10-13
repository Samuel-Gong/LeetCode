package cn.edu.nju.leetcode.problems;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/9/25
 */
public class Assignment1071 {
    static class Solution {
        public String gcdOfStrings(String str1, String str2) {
            if ((str1 + str2).equals(str2 + str1)) {
                return str1.substring(0, gcd(Math.min(str1.length(), str2.length()), Math.max(str1.length(), str2.length())));
            }
            return "";
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
        System.out.println(solution.gcdOfStrings("LEET", "code"));
    }
}
