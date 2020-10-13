package cn.edu.nju.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
 * 例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/10/14
 */
public class LeetCode1002 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.commonChars(new String[]{"bella", "label", "roller"}));
    }

    /**
     * 根据题意是小写字母，根据题目限定范围来使用数组代替 map
     */
    static class Solution {
        public List<String> commonChars(String[] A) {
            if (A == null || A.length == 0) return new ArrayList<>();
            int[] minFreq = new int[26];
            Arrays.fill(minFreq, Integer.MAX_VALUE);
            int[] freq = new int[26];
            for (int i = 0; i < A.length; i++) {
                String str = A[i];
                char c;
                for (int j = 0; j < str.length(); j++) {
                    c = str.charAt(j);
                    freq[c - 'a']++;
                }
                for (int j = 0; j < minFreq.length; j++) {
                    minFreq[j] = Math.min(minFreq[j], freq[j]);
                    freq[j] = 0;
                }
            }

            List<String> res = new ArrayList<>();
            for (int i = 0; i < minFreq.length; i++) {
                String c = "" + (char) ('a' + i);
                for (int j = 0; j < minFreq[i]; j++) {
                    res.add(c);
                }
            }
            return res;
        }
    }
}
