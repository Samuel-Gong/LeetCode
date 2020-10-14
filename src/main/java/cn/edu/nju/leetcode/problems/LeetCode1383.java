package cn.edu.nju.leetcode.problems;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/10/14
 */
public class LeetCode1383 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxPerformance(6, new int[]{2, 10, 3, 1, 5, 8}, new int[]{5, 4, 3, 9, 7, 2}, 2));
    }

    /**
     * 将工程师按照效率从高到低排序
     * 每次选择第 i 个作为最低效率工程师，利用最小堆存放 0..i-1 中前 k-1 个最大的 speed
     * 遍历一次 engineers，更新最大结果
     */
    static class Solution {
        public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
            int[][] engineers = new int[n][2];
            for (int i = 0; i < n; i++) {
                engineers[i] = new int[]{speed[i], efficiency[i]};
            }
            Arrays.sort(engineers, (e1, e2) -> e2[1] - e1[1]);
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            long ans = 0, sumS = 0;
            for (int i = 0; i < n; i++) {
                // 保留至多 k-1 个
                if (pq.size() > k - 1) {
                    sumS -= pq.poll();
                }
                int minE = engineers[i][1];
                sumS += engineers[i][0];
                ans = Math.max(ans, sumS * minE);
                pq.offer(engineers[i][0]);
            }
            return (int) (ans % ((int) 1e9 + 7));
        }
    }
}
