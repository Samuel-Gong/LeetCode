package cn.edu.nju.leetcode.problems.interview;

import java.util.Arrays;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/10/4
 */
public class Interview0108 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = new int[][]{
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        solution.setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    /**
     * 第一行用来记录某列是否存在 0
     * 第一列用来记录某行是否存在 0
     * 两个标记位先记录第一行第一列本身是否存在 0
     * 最后根据标记位来填充第一行第一列的 0
     * <p>
     * 注意最后根据第一行第一列遍历矩阵的时候，是从 1 开始遍历的
     */
    static class Solution {
        public void setZeroes(int[][] matrix) {
            if (matrix == null || matrix.length == 0) return;
            boolean isFirstRowZero = false;
            boolean isFirstColZero = false;
            for (int i = 0; i < matrix[0].length; i++) {
                if (matrix[0][i] == 0) {
                    isFirstRowZero = true;
                    break;
                }
            }
            for (int[] row : matrix) {
                if (row[0] == 0) {
                    isFirstColZero = true;
                    break;
                }
            }
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[0][j] = 0;
                        matrix[i][0] = 0;
                    }
                }
            }
            for (int i = 1; i < matrix[0].length; i++) {
                if (matrix[0][i] == 0) {
                    for (int j = 1; j < matrix.length; j++) {
                        matrix[j][i] = 0;
                    }
                }
            }
            for (int i = 1; i < matrix.length; i++) {
                if (matrix[i][0] == 0) {
                    Arrays.fill(matrix[i], 0);
                }
            }
            if (isFirstRowZero) {
                Arrays.fill(matrix[0], 0);
            }
            if (isFirstColZero) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][0] = 0;
                }
            }
        }
    }
}
