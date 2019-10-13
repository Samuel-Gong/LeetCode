package cn.edu.nju.leetcode.contest;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/9/21
 */
public class Assignment5071 {
    static class Solution {
        public int smallestCommonElement(int[][] mat) {
            List<Integer> same = new ArrayList();
            int cols = mat[0].length;
            if (mat.length == 1) {
                return mat[0][0];
            }
            for (int m = 0, n = 0; m < cols && n < cols; ) {
                if (mat[0][m] < mat[1][n]) {
                    m++;
                } else if (mat[0][m] > mat[1][n]) {
                    n++;
                } else {
                    same.add(mat[0][m]);
                    m++;
                    n++;
                }
            }
            for (int i = 2; i < mat.length; i++) {
                for (int m = 0, n = 0; m < cols && n < same.size(); ) {
                    if (mat[i][m] < same.get(n)) {
                        m++;
                    } else if (mat[i][m] > same.get(n)) {
                        same.remove(n);
                    } else {
                        m++;
                        n++;
                    }
                }
            }

            if (same.isEmpty()) {
                return -1;
            } else {
                return same.get(0);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.smallestCommonElement(new int[][]{{1, 2, 3, 4, 5}, {2, 4, 5, 8, 10}, {3, 5, 7, 9, 11}, {1, 3, 5, 7, 9}}));
    }
}
