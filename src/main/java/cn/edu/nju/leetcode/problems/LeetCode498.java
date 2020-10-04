package cn.edu.nju.leetcode.problems;

import java.util.Arrays;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/10/4
 */
public class LeetCode498 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(Arrays.toString(solution.findDiagonalOrder(matrix)));
    }

    /**
     * 没有其它技巧，直接模拟题目描述的遍历方式
     */
    static class Solution {
        public int[] findDiagonalOrder(int[][] matrix) {
            if (matrix == null || matrix.length == 0) return new int[]{};
            int i = 0;
            int j = 0;
            int rowL = matrix.length;
            int colL = matrix[0].length;
            int[] res = new int[rowL * colL];
            int index = 0;
            // 用 order 来表示当前对角线的方向
            // order = 1，表示左下->右上对角线
            // order = 0，表示右上->左下对角线
            int order = 1;
            while (i < rowL && j < colL) {
                res[index++] = matrix[i][j];
                // 当前 i,j 在左下->右上对角线上
                if (order % 2 == 1) {
                    // 转换到右上->左下对角线
                    if (i == 0 || j == colL - 1) {
                        if (j < colL - 1) j++;
                        else i++;
                        order = 0;
                    } else {
                        i--;
                        j++;
                    }
                }
                // 当前 i,j 在右上->左下对角线上
                else {
                    // 转换到左下->右上对角线上
                    if (j == 0 || i == rowL - 1) {
                        if (i < rowL - 1) i++;
                        else j++;
                        order = 1;
                    } else {
                        i++;
                        j--;
                    }
                }
            }
            return res;
        }
    }
}
