package cn.edu.nju.leetcode.problems;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/9/20
 */
public class Assignment566 {
    static class Solution {
        public int[][] matrixReshape(int[][] nums, int r, int c) {
            if (nums.length * nums[0].length != r * c) {
                return nums;
            } else {
                int[][] res = new int[r][c];
                int curR = 0;
                int curC = 0;
                for (int i = 0; i < nums.length; i++) {
                    for (int j = 0; j < nums[0].length; j++) {
                        res[curR][curC++] = nums[i][j];
                        if (curC == c) {
                            curR++;
                            curC = 0;
                        }
                    }
                }
                return res;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.matrixReshape(new int[][]{{1,2},{3,4}}, 1, 4);
    }
}
