package cn.edu.nju.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/10/9
 */
public class LeetCode1461 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hasAllCodes("00110", 2));

        Solution2 solution2 = new Solution2();
        System.out.println(solution2.hasAllCodes("00110", 2));
    }

    /**
     * set 中存储 k 长度的子串
     * 但是每次都要计算子串的 hash 值，增加了时间以及存储成本
     */
    static class Solution {
        public boolean hasAllCodes(String s, int k) {
            Set<String> set = new HashSet<>();
            for (int i = 0; i <= s.length() - k; i++) {
                set.add(s.substring(i, i + k));
            }
            return set.size() == (int) Math.pow(2, k);
        }
    }

    /**
     * 运用滑动窗口，窗口大小为 k，将数值而非字符串作为 key
     * 长度为 k 的二进制字符串，总数有 2^k 个，使用一个数组来存储，而非哈希表
     * 首先计算 0...k-2 的数字值，此时窗口大小为 k-1
     * 左边表示高位，所以每向右增加一位，就表示将之前的数 * 2，并加上右边增加的数值（0 或 1）
     * 循环内，窗口每次先向右增加一位，设置存储表的对应值，再将当前数字的最左边的高位置为 0，表示滑动窗口左边收缩一位
     */
    static class Solution2 {
        public boolean hasAllCodes(String s, int k) {
            if (k >= s.length()) return false;
            boolean[] set = new boolean[1 << k];
            int cur = 0;
            for (int i = 0; i < k - 1; i++) {
                int digit = s.charAt(i) == '1' ? 1 : 0;
                cur = (cur << 1) + digit;
            }
            for (int i = k - 1; i < s.length(); i++) {
                int digit = s.charAt(i) == '1' ? 1 : 0;
                cur = (cur << 1) + digit;
                set[cur] = true;
                cur = cur & ~(1 << (k - 1));
            }
            for (boolean used : set) {
                if (!used) return false;
            }
            return true;
        }
    }
}
