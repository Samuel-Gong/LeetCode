package cn.edu.nju.leetcode.contest;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/9/24
 */
public class Assignment4 {
    class Solution {
        int count = 0;
        boolean[][] marked;

        public int domino(int n, int m, int[][] broken) {
            marked = new boolean[n][m];
            for (int[] b : broken) {
                marked[b[0]][b[1]] = true;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (marked[i][j]) {
                        continue;
                    }
                    // 向右
                    if (j < m - 1 && !marked[i][j] && !marked[i][j + 1]) {
                        count++;
                        marked[i][j] = true;
                        marked[i][j + 1] = true;
                    }
                    // 向下
                    if (i < n - 1 && !marked[i][j] && !marked[i + 1][j]) {
                        count++;
                        marked[i][j] = true;
                        marked[i + 1][j] = true;
                    }
                }
            }
            return count;
        }
    }
}
