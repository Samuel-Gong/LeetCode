package cn.edu.nju.leetcode.problems;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/9/27
 */
public class Assignment1014 {
    static class Solution {
        public int maxScoreSightseeingPair(int[] A) {
            int[] diff = new int[A.length];
            for (int i = 0; i < A.length; i++) {
                diff[i] = A[i] - i;
            }
            int maxDiff = diff[diff.length - 1];
            int max = A[A.length - 2] + maxDiff + A.length - 2;
            int pa = A.length - 2;
            int pd = diff.length - 1;
            while (--pa >= 0 && --pd >= 0) {
                maxDiff = Math.max(maxDiff, diff[pd]);
                max = Math.max(max, A[pa] + pa + maxDiff);
            }
            return max;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxScoreSightseeingPair(new int[]{1, 3, 5}));
    }
}
