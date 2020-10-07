package cn.edu.nju.leetcode.problems;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/10/7
 */
public class LeetCode28 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strStr("hello", "ll"));
        System.out.println(solution.strStr("aaaaa", "bba"));
    }

    /**
     * 采用 KMP 算法
     */
    static class Solution {
        public int strStr(String haystack, String needle) {
            if (haystack == null || needle == null || haystack.length() < needle.length()) return -1;
            if (needle.length() == 0) return 0;
            // 部分匹配表，通过模式字符串本身去构建 pmt
            // pmt[i] 表示 0...i 的最长公共前后缀
            // pmt 的构造过程可以看作是模式字符串的最长前缀去匹配最长后缀的过程
            int[] pmt = new int[needle.length()];
            // 初始化 pmt[0] = 0
            pmt[0] = 0;
            // 注意初始化 i = 1，j = 0，即将模式字符串后缀作为主字符串，前缀作为模式字符串，
            // 使用 0...len-2 去匹配 i...len-1
            int i = 1;
            int j = 0;
            while (i < needle.length()) {
                if (needle.charAt(i) == needle.charAt(j)) {
                    pmt[i] = j + 1;
                    i++;
                    j++;
                } else {
                    // 在 j 的地方失配，表示 0...j-1 是匹配的，最长公共前后缀为 pmt[j-1]
                    if (j > 0) j = pmt[j - 1];
                    // j == 0 时，可能 needle[i] != needle[j]，即不存在公共前后缀，此时需要将 i 向前移动一位
                    else i++;
                }
            }

            // 通过构造好的 pmt 进行匹配
            i = 0;
            j = 0;
            while (i < haystack.length() && j < needle.length()) {
                if (haystack.charAt(i) == needle.charAt(j)) {
                    i++;
                    j++;
                } else {
                    if (j > 0) j = pmt[j - 1];
                    else i++;
                }
            }
            if (j == needle.length()) return i - j;
            return -1;
        }
    }
}
