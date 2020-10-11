package cn.edu.nju.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/10/11
 */
public class LeetCode3 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    }

    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() == 0) return 0;
            int left = 0;
            int right = 0;
            int maxLen = 1;
            Set<Character> inWindow = new HashSet<>();
            while (right < s.length()) {
                while (inWindow.contains(s.charAt(right))) {
                    inWindow.remove(s.charAt(left++));
                }
                inWindow.add(s.charAt(right));
                maxLen = Math.max(right - left + 1, maxLen);
                right++;
            }
            return maxLen;
        }
    }
}
