package cn.edu.nju.leetcode.contest.contest_157;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/9/29
 */
public class Assignment2 {
    static class Solution {
        public int longestSubsequence(int[] arr, int difference) {
            if (arr.length == 0) {
                return 0;
            }
            int res = 0;
            int last;
            for (int i = 0; i < arr.length; i++) {
                List<Integer> l = new ArrayList<>();
                l.add(arr[i]);
                last = arr[i];
                for (int j = i + 1; j < arr.length; j++) {
                    if (last + difference == arr[j]) {
                        last = arr[j];
                        l.add(arr[j]);
                    }
                }
                res = Math.max(res, l.size());
            }
            return res;
        }
    }

    static class Solution2 {
        public int longestSubsequence(int[] arr, int diff) {
            int res = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                map.put(arr[i], 1 + map.getOrDefault(arr[i] - diff, 0));
                res = Math.max(res, map.get(arr[i]));
            }
            return res;
        }
    }

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        System.out.println(solution.longestSubsequence(new int[]{1, 5, 7, 8, 5, 3, 4, 2, 1}, -2));
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.longestSubsequence(new int[]{1, 5, 7, 8, 5, 3, 4, 2, 1}, -2));
        System.out.println(solution2.longestSubsequence(new int[]{1, 3, 5, 7}, 1));
    }
}
