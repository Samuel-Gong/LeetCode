package cn.edu.nju.leetcode.contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/9/24
 */
public class Assignment3 {


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.robot("URR", new int[][]{}, 3, 2);
    }

    static class Solution {
        public boolean robot(String command, int[][] obstacles, int x, int y) {
            Map<Integer, List<Integer>> x2y = new HashMap<>();
            for (int i = 0; i < obstacles.length; i++) {
                int nodeX = obstacles[i][0];
                int nodeY = obstacles[i][1];
                if (x2y.containsKey(nodeX)) {
                    x2y.get(nodeX).add(nodeY);
                } else {
                    List<Integer> ys = new ArrayList<>();
                    ys.add(nodeY);
                    x2y.put(nodeX, ys);
                }
            }
            int curX = 0;
            int curY = 0;
            while (true) {
                for (int i = 0; i < command.length(); i++) {
                    switch (command.charAt(i)) {
                        case 'U':
                            curY++;
                            break;
                        case 'R':
                            curX++;
                            break;
                        default:
                    }
                    if (curX == x && curY == y) {
                        return true;
                    } else if (checkObstacle(curX, curY, x2y)) {
                        return false;
                    } else if (curX > x || curY > y) {
                        return false;
                    }
                }
            }
        }

        private boolean checkObstacle(int curX, int curY, Map<Integer, List<Integer>> x2y) {
            List<Integer> ys = x2y.get(curX);
            if (ys == null) {
                return false;
            }
            for (int i = 0; i < ys.size(); i++) {
                if (curY == ys.get(i)) {
                    return true;
                }
            }
            return false;
        }

    }
}
