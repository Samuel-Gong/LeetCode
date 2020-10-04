package cn.edu.nju.leetcode.problems.interview;

import java.util.Arrays;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/10/3
 */
public class Interview0107 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix1 = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] matrix2 = new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        solution.rotate(matrix1);
        System.out.println(Arrays.deepToString(matrix1));

        solution.rotate(matrix2);
        System.out.println(Arrays.deepToString(matrix2));
    }

    /**
     * 找出顺时针旋转 90° 的规律
     * matrix[row][col] 顺时针旋转 90° 的位置是 matrix[col][len - row - 1]
     * 可以发现是 4 个位置循环替换，用临时变量保存一个值即可
     *
     * 还需要注意，不是遍历整个矩阵，而是矩阵的左上角
     */
    static class Solution {
        public void rotate(int[][] matrix) {
            if (matrix == null || matrix.length == 0) return;
            int len = matrix.length;
            for (int i = 0; i < len / 2; i++) {
                for (int j = 0; j < (len + 1) / 2; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[len - j - 1][i];
                    matrix[len - j - 1][i] = matrix[len - i - 1][len - j - 1];
                    matrix[len - i - 1][len - j - 1] = matrix[j][len - i - 1];
                    matrix[j][len - i - 1] = temp;
                }
            }
        }
    }
}
