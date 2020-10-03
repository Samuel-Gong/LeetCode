package cn.edu.nju.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/10/3
 */
public class LeetCode56 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
        System.out.println(Arrays.deepToString(solution.merge(new int[][]{{1, 4}, {4, 5}})));
        System.out.println(Arrays.deepToString(solution.merge(new int[][]{{1, 4}, {2, 3}})));
    }

    static class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals == null || intervals.length == 0) return new int[][]{};
            // 先按照左边界排序，再按照右边界排序
            Arrays.sort(intervals, (o1, o2) -> (o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]));
            int index = 0;
            int curL = intervals[index][0];
            int curR = intervals[index][1];
            List<int[]> list = new ArrayList<>();
            while (index < intervals.length) {
                if (intervals[index][0] >= curL && intervals[index][0] <= curR) {
                    curR = Math.max(curR, intervals[index][1]);
                } else {
                    list.add(new int[]{curL, curR});
                    curL = intervals[index][0];
                    curR = intervals[index][1];
                }
                index++;
            }
            list.add(new int[]{curL, curR});
            return list.toArray(new int[list.size()][]);
        }
    }
}
