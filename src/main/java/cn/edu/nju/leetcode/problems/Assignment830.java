package cn.edu.nju.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/9/25
 */
public class Assignment830 {
    static class Solution {
        public List<List<Integer>> largeGroupPositions(String S) {
            List<List<Integer>> res = new ArrayList<>();
            int p1;
            int count;
            for (int i = 0; i < S.length(); i++) {
                p1 = i;
                count = 1;
                while (i < S.length() - 1 && S.charAt(i) == S.charAt(i + 1)) {
                    count++;
                    i++;
                }
                if (count >= 3) {
                    res.add(Arrays.asList(p1, i));
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largeGroupPositions("abc"));
    }
}
