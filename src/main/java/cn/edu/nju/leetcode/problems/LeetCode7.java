package cn.edu.nju.leetcode.problems;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/9/28
 */
public class LeetCode7 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(120));
    }

    static class Solution {
        public int reverse(int x) {
            int res = 0;
            while (x != 0) {
                int next = x % 10;
                x /= 10;
                // 在计算的过程中进行判断，而不是计算出结果了再进行判断，否则会溢出
                if (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && next > 7) return 0;
                if (res < Integer.MIN_VALUE / 10 || res == Integer.MIN_VALUE / 10 && next < -8) return 0;
                res = res * 10 + next;
            }
            return res;
        }
    }

}
