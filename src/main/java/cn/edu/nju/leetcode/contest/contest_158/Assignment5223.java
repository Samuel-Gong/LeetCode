package cn.edu.nju.leetcode.contest.contest_158;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/10/13
 */
public class Assignment5223 {
    class Solution {
        public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
            List<List<Integer>> res = new ArrayList<>();
            int kx = king[0];
            int ky = king[1];
            int qx;
            int qy;
            int[][] dp = new int[8][8];
            dp[kx][ky] = 1;
            for (int i = 0; i < queens.length; i++) {
                qx = queens[i][0];
                qy = queens[i][1];
                dp[qx][qy] = 2;
            }
            // left
            for (int i = ky - 1; i >= 0; i--) {
                if (dp[kx][i] == 2) {
                    res.add(Arrays.asList(kx, i));
                    break;
                }
            }

            // right
            for (int i = ky + 1; i < dp[0].length && dp[kx][ky] != 2; i++) {
                if (dp[kx][i] == 2) {
                    res.add(Arrays.asList(kx, i));
                    break;
                }
            }

            // up
            for (int i = kx - 1; i >= 0; i--) {
                if (dp[i][ky] == 2) {
                    res.add(Arrays.asList(i, ky));
                    break;
                }
            }

            // down
            for (int i = kx + 1; i < dp.length; i++) {
                if (dp[i][ky] == 2) {
                    res.add(Arrays.asList(i, ky));
                    break;
                }
            }

            // left-up
            for (int i = kx - 1, j = ky - 1; i >= 0 && j >= 0; i--, j--) {
                if (dp[i][j] == 2) {
                    res.add(Arrays.asList(i, j));
                    break;
                }
            }

            // left-down
            for (int i = kx + 1, j = ky - 1; i < dp.length && j >= 0; i++, j--) {
                if (dp[i][j] == 2) {
                    res.add(Arrays.asList(i, j));
                    break;
                }
            }

            // right-up
            for (int i = kx - 1, j = ky + 1; i >= 0 && j < dp[0].length; i--, j++) {
                if (dp[i][j] == 2) {
                    res.add(Arrays.asList(i, j));
                    break;
                }
            }

            // right-down
            for (int i = kx + 1, j = ky + 1; i < dp.length && j < dp[0].length; i++, j++) {
                if (dp[i][j] == 2) {
                    res.add(Arrays.asList(i, j));
                    break;
                }
            }

            return res;
        }
    }
}
