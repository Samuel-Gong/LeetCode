package cn.edu.nju.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/9/28
 */
public class Assignment389 {
    static class Solution {
        public char findTheDifference(String s, String t) {
            char[] arr1 = s.toCharArray();
            char[] arr2 = t.toCharArray();

            List<Character> chars = new ArrayList<>();

            Arrays.sort(arr1);
            Arrays.sort(arr2);

            int p = 0;
            for (int i = 0; i < arr1.length; ) {
                if (arr2[p] != arr1[i]) {
                    return arr2[p];
                } else {
                    p++;
                    i++;
                }
            }

            if (p >= arr1.length) {
                return arr2[p];
            }

            return 'x';
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findTheDifference("abcd", "abcde"));
    }
}
