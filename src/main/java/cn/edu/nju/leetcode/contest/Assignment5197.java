package cn.edu.nju.leetcode.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/9/22
 */
public class Assignment5197 {

    static class Solution {
        public List<List<Integer>> minimumAbsDifference(int[] arr) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(arr);
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < arr.length - 1; i++) {
                int diff = arr[i + 1] - arr[i];
                if (diff < min) {
                    res.clear();
                    res.add(Arrays.asList(arr[i], arr[i + 1]));
                    min = diff;
                } else if (diff == min) {
                    res.add(Arrays.asList(arr[i], arr[i + 1]));
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumAbsDifference(new int[]{4, 2, 1, 3}));
    }

}
