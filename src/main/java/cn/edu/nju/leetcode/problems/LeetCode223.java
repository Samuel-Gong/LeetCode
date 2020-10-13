package cn.edu.nju.leetcode.problems;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/10/13
 */
public class LeetCode223 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
    }

    /**
     * https://leetcode-cn.com/problems/rectangle-area/solution/jian-dan-de-kao-lu-by-powcai/
     */
    static class Solution {
        public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
            int areaA = (C - A) * (D - B);
            int areaB = (G - E) * (H - F);
            // 先考虑无覆盖的情况
            if (B >= H || F >= D || E >= C || G <= A) {
                return areaA + areaB;
            }

            int left = Math.max(A, E);
            int right = Math.min(C, G);
            int top = Math.min(D, H);
            int bottom = Math.max(B, F);

            int intersectArea = (right - left) * (top - bottom);

            return areaA + areaB - intersectArea;
        }
    }
}
