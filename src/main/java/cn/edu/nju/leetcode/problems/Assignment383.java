package cn.edu.nju.leetcode.problems;

import java.util.Arrays;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/10/2
 */
public class Assignment383 {
    static class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            if (ransomNote.length() == 0 && magazine.length() == 0) {
                return true;
            } else if (ransomNote.length() == 0) {
                return true;
            } else if (magazine.length() == 0) {
                return false;
            }
            char[] r = ransomNote.toCharArray();
            char[] m = magazine.toCharArray();

            Arrays.sort(r);
            Arrays.sort(m);

            int i = 0, j = 0;
            while (i < r.length && j < m.length) {
                if (r[i] == m[j]) {
                    i++;
                    if (i == r.length) {
                        return true;
                    }
                    j++;
                } else if (r[i] < m[j]) {
                    return false;
                } else {
                    j++;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canConstruct("bcb",
                "cjjajdfaaeegig"));
    }
}
