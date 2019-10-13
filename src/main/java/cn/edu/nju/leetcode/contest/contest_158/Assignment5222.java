package cn.edu.nju.leetcode.contest.contest_158;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/10/13
 */
public class Assignment5222 {
    static class Solution {
        public int balancedStringSplit(String s) {
            char[] chars = s.toCharArray();
            int res = 0;
            int l = 0;
            int r = 0;
            for (int i = 0; i < s.length(); i++) {
                if (chars[i] == 'L') {
                    l++;
                }
                if (chars[i] == 'R') {
                    r++;
                }
                if (l == r) {
                    res++;
                    l = 0;
                    r = 0;
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.balancedStringSplit("RLRRLLRLRL"));
        System.out.println(solution.balancedStringSplit("RLLLLRRRLR"));
        System.out.println(solution.balancedStringSplit("LLLLRRRR"));
    }
}
