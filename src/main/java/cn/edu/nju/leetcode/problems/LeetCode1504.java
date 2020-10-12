package cn.edu.nju.leetcode.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/10/12
 */
public class LeetCode1504 {

    public static void main(String[] args) {
        int[][] matrix1 = new int[][]{
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0}
        };
        Solution solution = new Solution();
        Solution1 solution1 = new Solution1();
        System.out.println(solution.numSubmat(matrix1));
        System.out.println(solution1.numSubmat(matrix1));
    }

    /**
     * 动态规划
     * dp[i+1][j+1] 表示以 mat[i][j] 为右下角能够组成矩形的集合，dp[i+1][j+1] 与 dp[i][j+1], dp[i+1][j] 有关
     */
    static class Solution {
        public int numSubmat(int[][] mat) {
            if (mat == null || mat[0].length == 0) return 0;
            int res = 0;
            int l = mat.length;
            int w = mat[0].length;
            List<List<Set<Rectangle>>> dp = new ArrayList<>();
            for (int i = 0; i < l + 1; i++) {
                List<Set<Rectangle>> list = new ArrayList<>();
                for (int j = 0; j < w + 1; j++) {
                    list.add(new HashSet<>());
                }
                dp.add(list);
            }
            for (int i = 1; i < l + 1; i++) {
                for (int j = 1; j < w + 1; j++) {
                    if (mat[i - 1][j - 1] == 1) {
                        Set<Rectangle> cur = dp.get(i).get(j);
                        cur.add(new Rectangle(1, 1));
                        Set<Rectangle> up = dp.get(i - 1).get(j);
                        Set<Rectangle> left = dp.get(i).get(j - 1);
                        for (Rectangle r : up) {
                            if (r.length == 1) {
                                cur.add(new Rectangle(r.length, r.width + 1));
                            } else {
                                if (left.contains(new Rectangle(r.length - 1, r.width + 1))) {
                                    cur.add(new Rectangle(r.length, r.width + 1));
                                }
                            }
                        }
                        for (Rectangle r : left) {
                            if (r.width == 1) {
                                cur.add(new Rectangle(r.length + 1, r.width));
                            }
                        }
                        res += cur.size();
                    }
                }
            }
            return res;
        }

        class Rectangle {
            int length;
            int width;

            Rectangle(int l, int w) {
                length = l;
                width = w;
            }

            @Override
            public int hashCode() {
                return this.length * 31 + width;
            }

            @Override
            public boolean equals(Object obj) {
                if (obj == null) return false;
                Rectangle other = (Rectangle) obj;
                return this.length == other.length && this.width == other.width;
            }
        }
    }


    /**
     * row[i][j] 表示矩阵中 (i,j) 向左延伸连续 1 的个数
     * https://leetcode-cn.com/problems/count-submatrices-with-all-ones/solution/tong-ji-quan-1-zi-ju-xing-by-leetcode-solution/
     */
    static class Solution1 {
        public int numSubmat(int[][] mat) {
            if (mat == null || mat[0].length == 0) return 0;
            int r = mat.length;
            int c = mat[0].length;
            int[][] row = new int[r + 1][c + 1];
            for (int i = 1; i < r + 1; i++) {
                for (int j = 1; j < c + 1; j++) {
                    if (mat[i - 1][j - 1] == 1) {
                        row[i][j] = row[i][j - 1] + 1;
                    }
                }
            }

            int res = 0;
            for (int i = 1; i < r + 1; i++) {
                for (int j = 1; j < c + 1; j++) {
                    int col = row[i][j];
                    for (int k = i; k >= 1 && row[k][j] > 0; k--) {
                        col = Math.min(row[k][j], col);
                        res += col;
                    }
                }
            }
            return res;
        }
    }
}
