package cn.edu.nju.leetcode.problems;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/9/26
 */
public class Assignment795 {
    static class Solution {
        public int numSubarrayBoundedMax(int[] A, int L, int R) {
            int cnt = 0;
            int curSubStart = -1;
            int curSubMax = -1;
            for (int i = 0; i < A.length; i++) {
                if (A[i] > curSubMax) {

                } else {

                }
                if (A[i] >= L && A[i] <= R) {
                    if (curSubStart != -1) {
                        cnt += i - curSubStart + 1;
                    } else {
                        cnt += 1;
                        curSubStart = i;
                    }
                } else {
                    curSubStart = -1;
                }
            }
            return cnt;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numSubarrayBoundedMax(new int[]{2, 1, 4, 3}, 2, 3));
    }
}
