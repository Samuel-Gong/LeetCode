package cn.edu.nju.leetcode.problems;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/9/30
 */
public class LeetCode557 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseWords("Let's take LeetCode contest"));
        System.out.println(solution.reverseWords("   Let's take LeetCode contest"));
        System.out.println(solution.reverseWords("Let's take LeetCode contest   "));
        System.out.println(solution.reverseWords("   "));
    }

    static class Solution {
        public String reverseWords(String s) {
            StringBuilder sb = new StringBuilder(s);
            int i;
            int j = 0;
            while (j < sb.length()) {
                if (sb.charAt(j) == ' ') j++;
                else {
                    i = j;
                    while (j < sb.length() && sb.charAt(j) != ' ') j++;
                    reverseWord(sb, i, j - 1);
                }
            }
            return sb.toString();
        }

        public void reverseWord(StringBuilder sb, int left, int right) {
            char tmp;
            while (left < right) {
                tmp = sb.charAt(left);
                sb.setCharAt(left, sb.charAt(right));
                sb.setCharAt(right, tmp);
                left++;
                right--;
            }
        }
    }
}
