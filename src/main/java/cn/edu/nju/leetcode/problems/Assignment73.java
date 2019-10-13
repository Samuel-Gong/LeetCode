package cn.edu.nju.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 * <p>
 *
 * @author Shenmiu
 * @date 2019/9/19
 */
public class Assignment73 {

    /**
     * 额外空间 O(m)
     */
    static class Solution {
        public void setZeroes(int[][] matrix) {
            boolean[] colZero = new boolean[matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == 0) {
                        // 向上
                        for (int m = i - 1; m >= 0; m--) {
                            matrix[m][j] = 0;
                        }
                        // 向左
                        for (int m = j - 1; m >= 0; m--) {
                            matrix[i][m] = 0;
                        }
                        // 向右
                        for (int m = j + 1; m < matrix[0].length; m++) {
                            if (matrix[i][m] == 0) {
                                colZero[m] = true;
                                // 向上
                                for (int k = i - 1; k >= 0; k--) {
                                    matrix[k][m] = 0;
                                }
                            } else {
                                matrix[i][m] = 0;
                            }
                        }
                        colZero[j] = true;
                        break;
                    } else if (colZero[j]) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }

    static class Solution2 {
        public void setZeroes(int[][] matrix) {
            List<int[]> rowCol = new ArrayList<>();
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == 0) {
                        rowCol.add(new int[]{i, j});
                    }
                }
            }

            for (int[] rc : rowCol) {
                // 上下
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][rc[1]] = 0;
                }

                // 左右
                for (int i = 0; i < matrix[0].length; i++) {
                    matrix[rc[0]][i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        int[][] arr = new int[][]{{3, 5, 5, 6, 9, 1, 4, 5, 0, 5}, {2, 7, 9, 5, 9, 5, 4, 9, 6, 8}, {6, 0, 7, 8, 1, 0, 1, 6, 8, 1}, {7, 2, 6, 5, 8, 5, 6, 5, 0, 6}, {2, 3, 3, 1, 0, 4, 6, 5, 3, 5}, {5, 9, 7, 3, 8, 8, 5, 1, 4, 3}, {2, 4, 7, 9, 9, 8, 4, 7, 3, 7}, {3, 5, 2, 8, 8, 2, 2, 4, 9, 8}};
        int[][] arr2 = new int[][]{{3, 5, 5, 6, 9, 1, 4, 5, 0, 5}, {2, 7, 9, 5, 9, 5, 4, 9, 6, 8}, {6, 0, 7, 8, 1, 0, 1, 6, 8, 1}, {7, 2, 6, 5, 8, 5, 6, 5, 0, 6}, {2, 3, 3, 1, 0, 4, 6, 5, 3, 5}, {5, 9, 7, 3, 8, 8, 5, 1, 4, 3}, {2, 4, 7, 9, 9, 8, 4, 7, 3, 7}, {3, 5, 2, 8, 8, 2, 2, 4, 9, 8}};
        solution.setZeroes(arr);
        solution2.setZeroes(arr2);
        System.out.println(Arrays.deepToString(arr));
        System.out.println(Arrays.deepToString(arr2));
        System.out.println(Arrays.deepToString(arr).equals(Arrays.deepToString(arr2)));
    }
}
