package cn.edu.nju.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/10/17
 */
public class LeetCode52 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.totalNQueens(4));
    }

    static class Solution {
        int res = 0;
        int N;

        public int totalNQueens(int n) {
            N = n;
            // 保存已有皇后的列
            boolean[] columns = new boolean[n];
            // 保存左上到右下对角线的行-列的差，表示那条对角线上已经有皇后了
            // (0,0), (1,1), (2,2) row-col = 0
            // (0,1), (1,2) row-col = -1
            // 左上到右下对角线的行列差相等
            Set<Integer> diagonals1 = new HashSet<>();
            // 保存右上到左下对角线的行+列的和，表示那条对角线上已经有皇后了
            // (1,3), (2,2), (3,1)
            // 右上到左下对角线的行列和相等
            Set<Integer> diagonals2 = new HashSet<>();
            backtrack(0, columns, diagonals1, diagonals2);
            return res;
        }

        /**
         * 按照行进行递归，每一行选择一个皇后，行内对每一列进行遍历
         *
         * @param row        当前行
         * @param columns    保存已有皇后的列
         * @param diagonals1 保存已有皇后的、从左上到右下方向的对角线
         * @param diagonals2 保存已有皇后的、从右上到左下方向的对角线
         */
        public void backtrack(int row, boolean[] columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
            // 结束条件为达到目标皇后数量
            if (row == N) {
                res++;
                return;
            }
            for (int col = 0; col < N; col++) {
                // 判断当前位置是否可以放置皇后
                // 需要判断列和两个方向的对角线
                if (columns[col]) continue;
                if (diagonals1.contains(row - col)) continue;
                if (diagonals2.contains(row + col)) continue;

                columns[col] = true;
                diagonals1.add(row - col);
                diagonals2.add(row + col);
                backtrack(row + 1, columns, diagonals1, diagonals2);
                columns[col] = false;
                diagonals1.remove(row - col);
                diagonals2.remove(row + col);
            }
        }
    }
}
