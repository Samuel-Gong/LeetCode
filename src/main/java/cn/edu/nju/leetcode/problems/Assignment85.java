package cn.edu.nju.leetcode.problems;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/9/25
 */
public class Assignment85 {
    class Solution {
        public int maximalRectangle(char[][] matrix) {
            Tuple[][] rd = new Tuple[matrix.length][matrix[0].length];
            int max = 0;
            for (int i = matrix.length - 1; i >= 0; i--) {
                for (int j = matrix[0].length - 1; j >= 0; j--) {
                    if (matrix[i][j] == 0) {
                        rd[i][j] = new Tuple(0, 0, 0, 0);
                    } else {
                        Tuple tuple = new Tuple(1, 1, 1, 1);
                        if (i == matrix.length - 1) {
                            tuple.upRow = 1;
                            tuple.upCol = 1;
                        } else {
                            tuple.upRow += rd[i + 1][j].upRow;
                            tuple.upCol = 1;
                        }
                        if (j == matrix[0].length - 1) {
                            tuple.leftRow = 1;
                            tuple.leftCol = 1;
                        } else {
                            tuple.leftCol += rd[i][j + 1].leftCol;
                            tuple.leftRow = 1;
                        }
                    }
                }
            }
            return 0;
        }

        class Tuple {
            int leftRow;
            int leftCol;

            int upRow;
            int upCol;

            Tuple(int leftRow, int leftCol, int upRow, int upCol) {
                this.leftRow = leftRow;
                this.leftCol = leftCol;
                this.upRow = upRow;
                this.upCol = upCol;
            }
        }
    }
}
