package cn.edu.nju.leetcode.problems;

import java.util.*;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/9/30
 */
public class LeetCode51 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solveNQueens(4));
    }

    /**
     * 通过回溯算法解决
     */
    static class Solution {

        List<List<String>> res = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {
            List<StringBuilder> initBoard = new ArrayList<>();
            char[] arr = new char[n];
            Arrays.fill(arr, '.');
            for (int i = 0; i < n; i++) {
                initBoard.add(new StringBuilder(new String(arr)));
            }
            // 保存已有皇后的列
            int[] columns = new int[n];
            // 保存左上到右下对角线的行-列的差，表示那条对角线上已经有皇后了
            // (0,0), (1,1), (2,2) row-col = 0
            // (0,1), (1,2) row-col = -1
            // 左上到右下对角线的行列差相等
            Set<Integer> diagonals1 = new HashSet<>();
            // 保存右上到左下对角线的行+列的和，表示那条对角线上已经有皇后了
            // (1,3), (2,2), (3,1)
            // 右上到左下对角线的行列和相等
            Set<Integer> diagonals2 = new HashSet<>();
            backtrack(initBoard, 0, columns, diagonals1, diagonals2);
            return res;
        }

        /**
         * 按照行进行递归，每一行选择一个皇后，行内对每一列进行遍历
         *
         * @param board      当前棋盘
         * @param row        当前行
         * @param columns    保存已有皇后的列
         * @param diagonals1 保存已有皇后的、从左上到右下方向的对角线
         * @param diagonals2 保存已有皇后的、从右上到左下方向的对角线
         */
        public void backtrack(List<StringBuilder> board, int row, int[] columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
            // 结束条件为达到目标皇后数量
            if (row == board.size()) {
                List<String> solution = new ArrayList<>();
                for (StringBuilder sb : board) {
                    solution.add(sb.toString());
                }
                res.add(solution);
                return;
            }
            StringBuilder rowStr = board.get(row);
            for (int col = 0; col < board.size(); col++) {
                // 判断当前位置是否可以放置皇后
                // 需要判断列和两个方向的对角线
                if (columns[col] != 0) continue;
                if (diagonals1.contains(row - col)) continue;
                if (diagonals2.contains(row + col)) continue;

                columns[col] = 1;
                diagonals1.add(row - col);
                diagonals2.add(row + col);
                rowStr.setCharAt(col, 'Q');
                backtrack(board, row + 1, columns, diagonals1, diagonals2);
                rowStr.setCharAt(col, '.');
                columns[col] = 0;
                diagonals1.remove(row - col);
                diagonals2.remove(row + col);
            }
        }
    }
}
