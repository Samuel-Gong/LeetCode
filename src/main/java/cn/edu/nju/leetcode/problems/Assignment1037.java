package cn.edu.nju.leetcode.problems;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/10/13
 */
public class Assignment1037 {
    static class Solution {
        public boolean isBoomerang(int[][] points) {

            for (int i = 0; i < points.length; i++) {
                if (points[i][0] == points[(i + 1) % points.length][0] && points[i][1] == points[(i + 1) % points.length][1]) {
                    return false;
                }
            }

            if ((points[0][0] == points[1][0]) && (points[1][0] == points[2][0])) {
                return false;
            } else if (points[1][0] - points[0][0] != 0 && points[2][0] - points[1][0] != 0 && ((points[1][1] - points[0][1]) * 1.0 / (points[1][0] - points[0][0]) == (points[2][1] - points[1][1]) * 1.0 / (points[2][0] - points[1][0]))) {
                return false;
            }

            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isBoomerang(new int[][]{{0, 1}, {2, 1}, {0, 0}}));
    }
}
