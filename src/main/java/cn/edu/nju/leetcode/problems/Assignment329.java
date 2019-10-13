package cn.edu.nju.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/9/20
 */
public class Assignment329 {
    // 超时解法
    static class Solution {
        private int cols;

        public int longestIncreasingPath(int[][] matrix) {
            if (matrix.length == 0) {
                return 0;
            }
            this.cols = matrix[0].length;
            // 构造有向图
            int nodeNum = matrix.length * matrix[0].length;
            DiGraph g = new DiGraph(nodeNum);
            int[] inDegree = new int[nodeNum];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    // 添加边
                    // 检查上面
                    if (i > 0 && matrix[i][j] < matrix[i - 1][j]) {
                        g.addEdge(dimensionConvert(i, j), dimensionConvert(i - 1, j));
                        inDegree[dimensionConvert(i - 1, j)]++;
                    }

                    // 检查下面
                    if (i < matrix.length - 1 && matrix[i][j] < matrix[i + 1][j]) {
                        g.addEdge(dimensionConvert(i, j), dimensionConvert(i + 1, j));
                        inDegree[dimensionConvert(i + 1, j)]++;
                    }

                    // 检查左面
                    if (j > 0 && matrix[i][j] < matrix[i][j - 1]) {
                        g.addEdge(dimensionConvert(i, j), dimensionConvert(i, j - 1));
                        inDegree[dimensionConvert(i, j - 1)]++;
                    }

                    // 检查右面
                    if (j < matrix[0].length - 1 && matrix[i][j] < matrix[i][j + 1]) {
                        g.addEdge(dimensionConvert(i, j), dimensionConvert(i, j + 1));
                        inDegree[dimensionConvert(i, j + 1)]++;
                    }
                }
            }

            int max = 1;
            for (int v = 0; v < g.V(); v++) {
                if (inDegree[v] == 0) {
                    max = Math.max(max, findMaxGivenSource(g, v));
                }
            }

            return max;
        }

        private int findMaxGivenSource(DiGraph g, int s) {
            boolean[] marked = new boolean[g.V()];
            return dfs(g, s, marked);
        }

        private int dfs(DiGraph g, int v, boolean[] marked) {
            marked[v] = true;
            if (g.adj(v).isEmpty()) {
                return 1;
            }
            int max = 1;
            for (int w : g.adj(v)) {
                max = Math.max(max, dfs(g, w, marked));
            }
            return 1 + max;
        }

        private int dimensionConvert(int x, int y) {
            return x * cols + y;
        }

        private class DiGraph {
            private List<List<Integer>> adj;

            private final int V;

            public DiGraph(int V) {
                this.V = V;
                adj = new ArrayList<>();
                for (int i = 0; i < V; i++) {
                    adj.add(new ArrayList<>());
                }
            }

            public void addEdge(int v, int w) {
                adj.get(v).add(w);
            }

            public DiGraph reverse() {
                DiGraph r = new DiGraph(V);
                for (int i = 0; i < V; i++) {
                    for (int w : adj.get(i)) {
                        r.addEdge(w, i);
                    }
                }
                return r;
            }

            public List<Integer> adj(int v) {
                return adj.get(v);
            }

            public int V() {
                return V;
            }
        }

    }

    //
    static class Solution1 {
        private boolean[][] marked;
        private int[][] path;
        private int[][] matrix;

        public int longestIncreasingPath(int[][] matrix) {
            this.matrix = matrix;
            if (matrix.length == 0) {
                return 0;
            }
            int rows = matrix.length;
            int cols = matrix[0].length;
            marked = new boolean[rows][cols];
            path = new int[rows][cols];
            int max = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (!marked[i][j]) {
                        path[i][j] = dfs(i, j);
                        max = Math.max(max, path[i][j]);
                    }
                }
            }
            return max;
        }

        private int dfs(int row, int col) {
            // 添加边
            // 检查上面
            int max = 0;
            marked[row][col] = true;
            if (row > 0 && matrix[row][col] < matrix[row - 1][col]) {
                if (!marked[row - 1][col]) {
                    path[row - 1][col] = dfs(row - 1, col);
                }
                max = Math.max(max, path[row - 1][col]);
            }

            // 检查下面
            if (row < matrix.length - 1 && matrix[row][col] < matrix[row + 1][col]) {
                if (!marked[row + 1][col]) {
                    path[row + 1][col] = dfs(row + 1, col);
                }
                max = Math.max(max, path[row + 1][col]);
            }

            // 检查左面
            if (col > 0 && matrix[row][col] < matrix[row][col - 1]) {
                if (!marked[row][col - 1]) {
                    path[row][col - 1] = dfs(row, col - 1);
                }
                max = Math.max(max, path[row][col - 1]);
            }

            // 检查右面
            if (col < matrix[0].length - 1 && matrix[row][col] < matrix[row][col + 1]) {
                if (!marked[row][col + 1]) {
                    path[row][col + 1] = dfs(row, col + 1);
                }
                max = Math.max(max, path[row][col + 1]);
            }
            return max + 1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.longestIncreasingPath(new int[][]{{0,1},{19,18},{20,21}}));
        System.out.println(solution.longestIncreasingPath(new int[][]{{0,1},{19,18},{20,21},{39,38},{40,41},{59,58},{60,61},{79,78},{80,81},{99,98},{100,101},{119,118},{120,121},{139,138},{0,0}}));

        Solution1 solution1 = new Solution1();
//        System.out.println(solution1.longestIncreasingPath(new int[][]{{0,1},{19,18},{20,21}}));
        System.out.println(solution1.longestIncreasingPath(new int[][]{{0,1},{19,18},{20,21},{39,38},{40,41},{59,58},{60,61},{79,78},{80,81},{99,98},{100,101},{119,118},{120,121},{139,138},{0,0}}));
    }
}
