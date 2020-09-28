package cn.edu.nju.leetcode.problems;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/9/28
 */
public class LeetCode5 {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.longestPalindrome("babad"));
        System.out.println(solution1.longestPalindrome("cbbd"));

        Solution2 solution2 = new Solution2();
        System.out.println(solution2.longestPalindrome("babad"));
        System.out.println(solution2.longestPalindrome("cbbd"));
        System.out.println(solution2.longestPalindrome("a"));
    }

    // 中心扩散法，对字符串中的每个位置像两边扩散，O(n^2)
    static class Solution1 {
        public String longestPalindrome(String s) {
            if (s == null || s.length() == 0) return s;
            int maxLen = 1;
            int start = 0;
            for (int i = 0; i < s.length(); i++) {
                int start1 = palindrome(s, i, i);
                int start2 = palindrome(s, i, i + 1);
                if ((i - start1) * 2 + 1 > maxLen) {
                    maxLen = (i - start1) * 2 + 1;
                    start = start1;
                }
                if ((i - start2) * 2 + 2 > maxLen) {
                    maxLen = (i - start2) * 2 + 2;
                    start = start2;
                }
            }
            return s.substring(start, start + maxLen);
        }

        public int palindrome(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            return left + 1;
        }
    }

    // 动态规划
    static class Solution2 {
        public String longestPalindrome(String s) {
            if (s == null || s.length() == 0) return s;
            int maxLen = 1;
            int start = 0;
            boolean[][] dp = new boolean[s.length()][s.length()];
            for (int i = 0; i < s.length(); i++) {
                dp[i][i] = true;
            }
            for (int i = s.length() - 1; i >= 0; i--) {
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(j) == s.charAt(i)) {
                        if (j - i < 3) {
                            dp[i][j] = true;
                        } else {
                            dp[i][j] = dp[i + 1][j - 1];
                        }
                    } else {
                        dp[i][j] = false;
                    }
                    if (dp[i][j]) {
                        if (j - i + 1 > maxLen) {
                            maxLen = j - i + 1;
                            start = i;
                        }
                    }
                }
            }
            return s.substring(start, start + maxLen);
        }
    }
}
