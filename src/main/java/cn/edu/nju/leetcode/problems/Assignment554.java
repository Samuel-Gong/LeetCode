package cn.edu.nju.leetcode.problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/10/8
 */
public class Assignment554 {
    static class Solution {
        public int leastBricks(List<List<Integer>> wall) {
            int cross = 0;
            int breadth = 0;
            for (int i : wall.get(0)) {
                breadth += i;
            }

            int res = wall.size();
            int[] indicies = new int[wall.size()];
            int[] curLen = new int[wall.size()];
            for (int i = 1; i < breadth; i++) {
                for (int j = 0; j < wall.size(); j++) {
                    if (curLen[j] > i) {
                        continue;
                    }
                    if (curLen[j] == i) {
                        cross--;
                        continue;
                    }
                    while (curLen[j] < i) {
                        curLen[j] += wall.get(j).get(indicies[j]);
                        indicies[j]++;
                    }
                    if (curLen[j] > i || (curLen[j] == i && indicies[j] == wall.get(j).size())) {
                        cross++;
                    }
                }
                res = Math.min(cross, res);
            }

            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.leastBricks(
                Arrays.asList(Arrays.asList(1, 2, 2, 1), Arrays.asList(3, 1, 2),
                        Arrays.asList(1, 3, 2), Arrays.asList(2, 4),
                        Arrays.asList(3, 1, 2), Arrays.asList(1, 3, 1, 1))));
        System.out.println(solution.leastBricks(
                Arrays.asList(Collections.singletonList(1), Collections.singletonList(1),
                        Collections.singletonList(1))));
        System.out.println(solution.leastBricks(
                Arrays.asList(Collections.singletonList(1), Collections.singletonList(1),
                        Collections.singletonList(2))));
    }
}
