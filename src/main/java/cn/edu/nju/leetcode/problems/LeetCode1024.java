package cn.edu.nju.leetcode.problems;

import java.util.Arrays;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/10/24
 */
public class LeetCode1024 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.videoStitching(new int[][]{{0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}}, 10));
        System.out.println(solution.videoStitching(new int[][]{{5, 7}, {1, 8}, {0, 0}, {2, 3}, {4, 5}, {0, 6}, {5, 10}, {7, 10}}, 5));

        Solution1 solution1 = new Solution1();
        System.out.println(solution1.videoStitching(new int[][]{{0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}}, 10));

        Solution2 solution2 = new Solution2();
        System.out.println(solution2.videoStitching(new int[][]{{0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}}, 10));
    }

    static class Solution {
        public int videoStitching(int[][] clips, int T) {
            Arrays.sort(clips, (a1, a2) -> a1[0] == a2[0] ? a2[1] - a1[1] : a1[0] - a2[0]);
            int cnt = 0;
            int right = 0;
            for (int i = 0; i < clips.length; ) {
                if (clips[i][0] > right) return -1;
                cnt++;
                int nextR = right;
                while (i < clips.length && clips[i][0] <= right) {
                    nextR = Math.max(nextR, clips[i][1]);
                    i++;
                }
                right = nextR;
                if (right >= T) return cnt;
            }
            if (right < T) return -1;
            return cnt;
        }
    }

    /**
     * 贪心策略
     */
    static class Solution1 {
        public int videoStitching(int[][] clips, int T) {
            // 保存以 clips[i][0] 为左端点的最右端点
            int[] maxR = new int[T];
            for (int[] clip : clips) {
                if (clip[0] < T) {
                    maxR[clip[0]] = Math.max(maxR[clip[0]], clip[1]);
                }
            }
            // 记录当前区间的最大位置
            int last = 0;
            // 记录上一个区间的最大位置
            int pre = 0;
            int cnt = 0;
            for (int i = 0; i < T; i++) {
                last = Math.max(last, maxR[i]);
                // 遍历位置 == 当前区间的最大位置，说明区间断裂，无法到达下一个位置
                if (i == last) {
                    return -1;
                }
                // 当遍历的位置 == 上一个区间结束的位置，说明进入了下一个区间
                // 更新区间数量和 pre
                if (i == pre) {
                    cnt++;
                    pre = last;
                }
            }
            return cnt;
        }
    }

    /**
     * 动态规划
     */
    static class Solution2 {
        public int videoStitching(int[][] clips, int T) {
            int[] dp = new int[T + 1];
            Arrays.fill(dp, T + 1);
            dp[0] = 0;
            for (int i = 1; i < T + 1; i++) {
                for (int[] clip : clips) {
                    if (clip[0] < i && clip[1] >= i) {
                        dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
                    }
                }
            }
            return dp[T] == T + 1 ? -1 : dp[T];
        }
    }
}
